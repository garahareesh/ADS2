import java.util.*;
class LongKRepeated{
	String s;
	String[] a;
	int n,k;
	HashMap<String, Integer> m;
	LongKRepeated(String s,int k)
	{
		this.s=s;
		this.n=s.length();
		a=new String[n];
		this.k=k;
		this.m=new HashMap();
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
	public String k_Repeated()
	{
		String result="",result2="";
		// for(int i=1;i<n;i++)
		// {
		// 	int len=lcp(a[i],a[i-1]);
		// 	String temp=a[i].substring(0,len);
		// 	if(!m.containsKey(temp)) m.put(temp,1);
		// 	else m.put(temp,m.get(temp)+1);
		// }
		for(int i=0;i<n-k;i++)
		{
			int len=lcp(a[i],a[i+1]);
			String temp=a[i].substring(0,len);
			if(lcp(temp,a[i+k])==temp.length())
			{
				if(temp.length()>result.length())
					result=temp;
				result2+=result+" ";
			}
		}
		return result2;
	}
	public static void main(String[] args) {
		 String s="mississippimississippi";
		//String s="aaakkkkaaallllaaa";
		LongKRepeated one=new LongKRepeated(s,3);
		System.out.println(one.k_Repeated());
		//System.out.println(one.m);
	}
}