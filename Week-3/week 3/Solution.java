import java.util.*;
class LSD
{
	String[] arr;
	public LSD()
	{
		
	}
	void sort(String[] arr,int d)
	{
		this.arr = arr;
		String[] aux = new String[arr.length];
		int R = 256;
		for(int w = d-1; w>=0; w--)
		{
			int count[] = new int[R+1];
			for(int i = 0; i<arr.length;i++)
			{
				count[arr[i].charAt(w)+1]++;
			}
			for(int r = 0; r<R;r++)
			{
				count[r+1] = count[r+1] + count[r];
			}
			for(int i=0;i<arr.length;i++)
			{
				aux[count[arr[i].charAt(w)]++] = arr[i]; 
			}
			for(int i=0;i<arr.length;i++)
			{
				arr[i] = aux[i];
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}

/*---------------------------------------------------------------------   MSD --------------------------------------------*/
class MSD
{
	String[] arr;
	public MSD()
	{

	}
	void sort(String[] arr)
	{
		this.arr = arr;
		String[] aux = new String[arr.length];
		sort(arr,aux,0,arr.length-1,0);
		System.out.println(Arrays.toString(arr));
	}
	void sort(String[] arr,String[] aux,int low,int high,int d)
	{
		if(high <= low) return;
		int R = 256;
		int count[] = new int[R+2];
		for(int i = low;i<=high;i++)
		{
			count[charAt(arr[i],d)+2]++;
		}
		for(int r = 0 ;r<R;r++)
		{
			count[r+1] = count[r] + count[r+1];
		}
		for(int i = low;i <=high;i++)
		{
			aux[count[charAt(arr[i],d)+1]++] = arr[i];
		}
		for(int i=low;i<=high;i++)
		{
			arr[i] = aux[i];
		}
		for(int r=0;r<R;r++)
		{
			sort(arr,aux,count[r]+low,count[r+1]-1+low,d+1);
		}
	}

	int charAt(String a,int d )
	{
		if(d == a.length()) return -1;
		else return a.charAt(d);
	}
}
/*------------------------------------------------------------ 3 WAY QUICK ----------------------------------*/
class ThreeWayQuick
{
	String[] arr;
	ThreeWayQuick()
	{
	}
	int charAt(String s,int d)
	{
		if(d==s.length()) return -1;
		return s.charAt(d);
	}
	void sort(String[] a)
	{
		this.arr = a;
		sort(arr,0,arr.length-1,0);
		// System.out.println(Arrays.toString(arr));
	}
	void sort(String[] a,int lo,int hi,int d)
	{
		if(hi<=lo) return;
		int lower_terminal = lo;
		int higher_terminal = hi;
		int pivot = charAt(a[lo],d);
		int i = lo+1;
		while(i<=higher_terminal)
		{
			int t = charAt(a[i],d);
			if(t < pivot) exch(a,lower_terminal++,i++);
			else if(t > pivot) exch(a,i,higher_terminal--);
			else i++;
		}
		sort(a,lo,lower_terminal-1,d);
		if(pivot >= 0) sort(a,lower_terminal,higher_terminal,d+1);
		sort(a,higher_terminal+1,hi,d);
	}
	void exch(String[] a,int i,int j)
	{
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
/*--------------------------------------------------------------LRS ---------------------------------------*/
class LRS
{
	public LRS()
	{

	}
	void lrs(String s)
	{
		String[] suffix = suffix(s);
		ThreeWayQuick radix = new ThreeWayQuick();
		radix.sort(suffix);
		String lrs = "";
		for(int i=0;i<suffix.length-1;i++)
		{
			int len = lcp(suffix[i],suffix[i+1]);
			if(len > lrs.length()) lrs = suffix[i].substring(0,len);
		}
		System.out.println("longest repeated substring "+lrs);
	}
	int lcp(String a,String b)
	{
		int min = Math.min(a.length(),b.length());
		for(int i=0;i<min;i++)
		{
			if(a.charAt(i)!=b.charAt(i)) return i;
		}
		return min;
	}
	String[] suffix(String s)
	{
		String[] sf = new String[s.length()];
		for(int i = 0;i<s.length();i++)
		{
			sf[i] = s.substring(i,s.length());
		}
		return sf;
	}
}
/*---------------------------------------------------------------------------------LCS----------------------------*/
class LCS
{
	public LCS()
	{

	}
	void lcs(String a,String b)
	{
		String[] suffix_a = suffix(a);
		String[] suffix_b = suffix(b);
		int len_a = a.length();
		int len_b = b.length();
		ThreeWayQuick radix = new ThreeWayQuick();
		radix.sort(suffix_a);
		radix.sort(suffix_b);
		int i=0;
		int j=0;
		String lcs = "";
		while(i<a.length() && j<b.length())
		{
			int p = index(suffix_a,len_a,i);
			int q = index(suffix_b,len_b,j);
			String lcp = lcp(a,p,b,q);
			if(lcp.length() > lcs.length()) lcs = lcp;
			if(compare(a,p,b,q) < 0) i++;
			else j++;
		}
		System.out.println("LOngest common substring    "+lcs);

 	}
 	int index(String[] s,int len,int i)
 	{
 		return (len - s[i].length());
 	}
 	String lcp(String a,int p,String b,int q)
 	{
 		int min = Math.min(a.length()-p,b.length()-q);
 		for(int i=0;i<min;i++)
 		{
 			if(a.charAt(i+p) != b.charAt(i+q)) return a.substring(p,p+i);
 		}
 		return a.substring(p,p+min);
 	}
 	String[] suffix(String s)
	{
		String[] sf = new String[s.length()];
		for(int i = 0;i<s.length();i++)
		{
			sf[i] = s.substring(i,s.length());
		}
		return sf;
	}
	int compare(String a,int p,String b,int q)
	{
		int min = Math.min(a.length()-p,b.length()-q);
		for(int i = 0; i<min; i++)
		{
			if(a.charAt(i+p) != b.charAt(i+q)) return a.charAt(i+p) - b.charAt(i+q);
		}
		if(a.length()-p < b.length()-q) return -1;
		else if(a.length()-p > b.length()-q) return 1;
		else return 0;
	}
}
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_cases = Integer.parseInt(sc.nextLine());
		for(int i=0;i<test_cases;i++)
		{
			String s1 = sc.nextLine();
			String[] str = s1.split(" ");
			String s2 = sc.nextLine();
			LCS lr = new LCS();
			lr.lcs(s1,s2);

			// MSD msd = new MSD();
			// msd.sort(str);
			// LSD lsd = new LSD();
			// lsd.sort(str,str[0].length());
			// ThreeWayQuick quick = new ThreeWayQuick();
			// quick.sort(str);
			// LRS l = new LRS();
			// l.lrs(s);

		}

	}
}