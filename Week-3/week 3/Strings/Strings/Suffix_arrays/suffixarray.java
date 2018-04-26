import java.util.*;
class suffixarray
{
	String s;
	public suffixarray(String s)
	{
		this.s=s;
	}
	public void suffixarraysort(String s,int w)
	{
		int n=s.length();
		String[] suffixes=new String[s.length()];
		for(int i=0;i<s.length();i++)
		{
			suffixes[i]=s.substring(i,n);
		}
		System.out.println(Arrays.toString(suffixes));
		sort(suffixes);
		System.out.println(Arrays.toString(suffixes));

		String[] result=new String[n];
		int j=0;
		for(int i=1;i<n;i++)
		{
			int len=lcp(suffixes[i],suffixes[i-1]);
			if(len>=w)
				result[j++]=suffixes[i].substring(0,len)+" ";
		}
		//return result;
		//System.out.println(result);
		//System.out.println(Arrays.toString(result));
		for(int i=0;i<result.length;i++)
		{
			if(result[i]!=null)
			{
			System.out.print(result[i]+" ");
			}
		}
	}
	public int lcp(String i,String j)
	{
	   int len=Math.min(i.length(),j.length());
	   for(int k=0;k<len;k++)
	   {
	   	if(i.charAt(k)!=j.charAt(k))
	   		return k;
	   } 
	   return len;
	}
	public int charAt(String s,int d)
	{
		if(d==s.length())
			return -1;
		return s.charAt(d);
	}
	public void sort(String[] s)
	{
		int n=s.length;
		sort(s,0,n-1,0);
	}
	public void sort(String[] a,int lo,int hi,int d)
	{
		if(hi<=lo)
			return;
		int i=lo;
		int j=hi;
		int v=charAt(a[lo],d);
		int k=lo+1;
		while(k<=j)
		{
			int t=charAt(a[k],d);
			if(t<v)
			{
				swap(a,i,k);
				i++;k++;
			}
			else if(t>v)
			{
				swap(a,k,j);
				j--;
			}
			else
				k++;
		}
		sort(a,lo,i-1,d);
		if(v>0)
			sort(a,i,j,d+1);
		sort(a,j+1,hi,d);
	}
	public void swap(String[] a,int i,int j)
	{
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void main(String[] args) {
		String s="abcdbcabcdefghdefaaa";
		suffixarray a=new suffixarray(s);
		a.suffixarraysort(s,2);
	}
}