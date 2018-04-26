import java.util.*;
class MyLongestKrepeated
{
	String s;
	String st[];
	int k;
	HashMap<String,Integer> h;
	public MyLongestKrepeated(String s)
	{
		this.k=2;
		this.s=s;
		h=new HashMap<String,Integer>();

		st=new String[s.length()];	
		for(int i=0;i<s.length();i++)
		{
			st[i]=s.substring(i);
		}
		Arrays.sort(st);
		// System.out.println(sArrays.toString(st));
		lkrs();

	}
	public int lcp(String s1,String s2)
	{
		int min=Math.min(s1.length(),s2.length());
		for(int i=0;i<min;i++)
		{
			if(s1.charAt(i)!=s2.charAt(i))
			{
				return i;
			}
		}
		return min;
	}
	public void lkrs()
	{
		String res="";
		for(int i=1;i<st.length;i++)
		{
			int len=lcp(st[i],st[i-1]);
			if(len>0)
			{
				if(!h.containsKey(st[i].substring(0,len)))
				{
					h.put(st[i].substring(0,len),2);
				}
				else
				{
					h.put(st[i].substring(0,len),h.get(st[i].substring(0,len))+2);
				}
				if(h.get(st[i].substring(0,len))>=k)
				{
					if((st[i].substring(0,len).length())>k){
						res=st[i].substring(0,len);																								

					}
					// res=st[i].substring(0,len);
					System.out.println("res  "+res);
				}
			}
		}
		// System.out.println(res+"-------");

	}

	public static void main(String[] args) {
		String s="mississippi";
		MyLongestKrepeated m=new MyLongestKrepeated(s);
	}
}