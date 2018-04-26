import java.util.*;
class LongRepeated
{
	String[] a;
	int k;
	int s1;
	LongRepeated(String s,int k)
	{
		this.s1=s.length();
		this.k=k;
		a=new String[s1];
		for(int i=0;i<s1;i++)
		{
			a[i]=s.substring(i,s1);
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
			{
				return i;
			}
		}
		return min;
	}
	public String LongRepeated()
	{
		String result="";
		for(int i=1;i<s1;i++)
		{
			int len=lcp(a[i],a[i-1]);
			{
				if(len>=k)
				{
					result+=a[i].substring(0,len)+" ";
				}
			}
		}
		
		return result;
		
	}
	public static void main(String[] args) {
		String a="mississippi";
		LongRepeated al=new LongRepeated(a,2);
		 System.out.println( al.LongRepeated());
	}
	
	
}