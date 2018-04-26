//implement Suffix
import java.util.*;
public class Suffix
{
	String [] suffix;
	int n;
	Suffix(String s)
	{
		n=s.length();
		suffix=new String[n];
		for(int i=0;i<n;i++)
		{
			suffix[i]=s.substring(i,n);
		}
		radixquicksort(suffix);
		// Arrays.sort(suffix);
	}
	public String longest()
	{
		String lrs="";
		for(int i=1;i<suffix.length;i++)
		{
			int len=lcp(suffix[i],suffix[i-1]);
			if(len>=lrs.length())
			{
				lrs=suffix[i].substring(0,len);

			}
		}
		return lrs;
	}
	public int lcp(String a, String b)
	{
		int min=Math.min(a.length(),b.length());
		for(int i=0;i<min;i++)
		{
			if(a.charAt(i)!=b.charAt(i)) return i;
		}return min;
	}
	public void radixquicksort(String [] suffix)
	{
		System.out.println(Arrays.toString(suffix));
		sort(suffix,0,suffix.length-1,0);
		// System.out.println(Arrays.toString(suffix));
	}
	public void sort(String [] a,int lo,int hi, int d)
	{
		if(hi<=lo) return;
		int lt=lo;
		int gt=hi;
		int pivot=charAt(a[lo],d);
		int i=lo+1;
		while(i<=gt)
		{
			int v=charAt(a[i],d);
			if(v<pivot) exch(a,lt++,i++);
			else if(v>pivot) exch(a,i,gt--);
			else i++;
		}
		sort(a,lo,lt-1,d);
		if(pivot>=0) sort(a,lt,gt,d+1);
		sort(a,gt+1,hi,d);
		suffix=a;
	}
	public void exch(String[] a, int i, int j)
	{
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public int charAt(String a, int c)
	{
		if(c==a.length()) return -1;
		return a.charAt(c);
	}
	public void display()
	{
		System.out.println(Arrays.toString(suffix));
	}
	public static void main(String[] args) {
		String a="mississippi";
		Suffix ob=new Suffix(a);
		System.out.println(ob.longest());
		ob.display();
	}
}