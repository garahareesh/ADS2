import java.util.Arrays;
import java.util.Arrays;
public class SuffixArrays {
	
	public SuffixArrays(String s) {
		int n = s.length();
		String[] suffixes = new String[n];
		for (int i = 0; i < n; i++) {
			suffixes[i] = s.substring(i, n);
		}
		sort(suffixes);
		System.out.println(Arrays.toString(suffixes));
		String lrs = "";
		for (int i = 1; i < n; i++) {
			int len = lcp(suffixes[i], suffixes[i-1]);
			if (len >= lrs.length())
				lrs = suffixes[i].substring(0, len);
		}
		System.out.println(lrs);
	}

	private int lcp(String s, String t) {
		int n = Math.min(s.length(), t.length());
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != t.charAt(i)) return i;
		}
		return n;
	}

	private int charAt(String s, int d) {
		if (d == s.length()) return -1;
		return s.charAt(d);
	}

	private void sort(String[] a) 
	{	sort(a, 0, a.length - 1, 0);	}

	private void sort(String[] a, int lo, int hi, int d) {
		if (hi <= lo) return;

		int lt = lo, gt = hi;
		int i = lo + 1;
		int v = charAt(a[lo], d);
		while (i <= gt) {
			int t = charAt(a[i], d);
			if 		(t < v) exch(a, i++, lt++);
			else if (t > v) exch(a, i, gt--);
			else			i++;
		}

		sort(a, lo, lt-1, d);
		if (v >= 0) sort(a, lt, gt, d+1);
		sort(a, gt+1, hi, d);
	}

	private void exch(String[] a, int i, int j) 
	{
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) 
	{
		// String s = "ABRACADABRA!";
		// String s ="nareshseran";
		String s="reyjafffafafafafafaaaaaaaaaa";
		SuffixArrays sa = new SuffixArrays(s);
	}
}