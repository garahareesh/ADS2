import java.util.*;
class LongestCommonSubStirng{
	String[] a,b;
	LongestCommonSubStirng(String x,String y)
	{
		a=new String[x.length()];
		b=new String[y.length()];
		for(int i=0;i<x.length();i++)
			a[i]=x.substring(i,x.length());
		for(int i=0;i<y.length();i++)
			b[i]=y.substring(i,y.length());
		String res="";
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				int len=lcp(a[i],b[j]);
				if(len>res.length())
					res=a[i].substring(0,len);
			}
		}
		System.out.println(res);
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
	public static void main(String[] args) {
		// String a="NagendraMsitiiit";
		// String b="MicrosoftNagendragoogle";
		String a="We strongly recommend you click here and practice it";
		String b="One should practice well for best results, click here";
		LongestCommonSubStirng one=new LongestCommonSubStirng(a,b);
	}
}