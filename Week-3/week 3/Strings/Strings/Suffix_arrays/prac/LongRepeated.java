import java.util.*;
class LongRepeated{
	String s;
	int k,n;
	String[] a;
	LongRepeated(String s, int k)
	{
		this.s=s;
		this.k=k;
		this.n=s.length();
		a=new String[n];
		for(int i=0;i<n;i++)
		{
			a[i]=s.substring(i,n);
		}
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	public int lcp(String a,String b)
	{
		int min=Math.min(a.length(),b.length());
		for(int i=0;i<min;i++)
		{
			if(a.charAt(i)!=b.charAt(i))
				return i;
		}
		return min;
	}
	public String longRepeated()
	{
		String res="";
		for(int i=1;i<n;i++)
		{
			int len=lcp(a[i],a[i-1]);
			if(len>=k){
				res+=a[i].substring(0,len)+"  ";
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String s="mississippi";
		LongRepeated one=new LongRepeated(s,2);
		System.out.println("longRepeated:"+one.longRepeated());
	}
}