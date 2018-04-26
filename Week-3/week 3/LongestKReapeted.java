import java.util.*;
public class LongestKReapeted
{
	HashMap<String,Integer> map;
	public LongestKReapeted()
	{
		map = new HashMap<>();
	}
	void lkrs(String s,int k)
	{
		String[] suffix = suffix(s);
		radixSort(suffix);
		String lrs = "";
		System.out.println(Arrays.toString(suffix));
		for(int i=0;i<suffix.length-1;i++)
		{
			int lcp = lcp(suffix[i],suffix[i+1]);
			if(lcp > lrs.length()) {
				lrs = suffix[i].substring(0,lcp);
				if(map.containsKey(lrs))
				{
					map.put(lrs,map.get(lrs)+2);
				}
				else map.put(lrs,2);
			}

		}
		System.out.println(map);
		for(String key : map.keySet())
		{
			if(key.equals(lrs) && map.get(key)>=k){
				System.out.println(key);
				return;
			}
		}
		System.out.println("no substring ");
		// System.out.println(map);
		// System.out.println(lrs);
	}
	int lcp(String a,String b)
	{
		int min = Math.min(a.length(),b.length());
		for(int i=0;i<min;i++)
		{
			if(a.charAt(i) != b.charAt(i)) return i;
		}
		return min;
	}
	String[] suffix(String s)
	{
		String[] sf = new String[s.length()];
		for(int i=0;i<s.length();i++)
		{
			sf[i] = s.substring(i,s.length());
		}
		return sf;
	}
	void radixSort(String[] s)
	{
		sort(s,0,s.length-1,0);
	}
	void sort(String[] s,int lo,int hi,int d)
	{
		if(hi<=lo) return;
		int lower_terminal = lo;
		int higher_terminal = hi;
		int pivot = charAt(s[lo],d);
		int i=lo+1;
		while(i<=higher_terminal)
		{
			int t = charAt(s[i],d);
			if(t < pivot) exch(s,lower_terminal++,i++);
			else if(t > pivot) exch(s,i,higher_terminal--);
			else i++;
		}
		sort(s,lo,lower_terminal-1,d);
		if(pivot>=0) sort(s,lower_terminal,higher_terminal,d+1);
		sort(s,higher_terminal+1,hi,d);
	}
	void exch(String[] a,int i,int j)
	{
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	int charAt(String s,int d)
	{
		if(d==s.length()) return -1;
		else return s.charAt(d);
	}
	public static void main(String[] args) {
		String s = "deepak1deepak2deepak3deepak4";
		LongestKReapeted lk = new LongestKReapeted();
		lk.lkrs(s,3);
	}
}