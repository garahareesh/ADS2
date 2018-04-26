import java.util.*;
class longestcommonsubstring
{
	String s,t,a[],b[];
	ArrayList <String>c;
	public longestcommonsubstring(String k,String l)
	{
		s=k;
		t=l;
		int n1=s.length();
		int n2=t.length();
		a=new String[n1];
		b=new String[n2];
		c=new ArrayList <String>();
		for (int i=0;i<n1;i++) {
			a[i]=s.substring(i,n1);
		}
		for (int i=0;i<n2;i++) {
			b[i]=t.substring(i,n2);
		}
		sort(a);
		sort(b);
		// System.out.println("a= "+Arrays.toString(a));
		// System.out.println("b= "+Arrays.toString(b));
	}
		public void sort(String a[])
	{
		sort(a,0,a.length-1,0);
	}
	public int Charat(String s,int d)
	{
		if (d==s.length()) {
			return -1;
		}
		return (int)s.charAt(d);
	}
	public void exch(String a[],int i,int j)
	{
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public void sort(String a[],int lo,int hi,int d)
	{
		if (lo>=hi) {
			return ;
		}
			int i=lo,it=lo;
			int gt=hi;
			int pivot=Charat(a[lo],d);
			while (gt>=i) {
				int t=Charat(a[i],d);
				if (pivot>t) {
					exch(a,i,it);
					i++;
					it++;
				}
				else if (t>pivot) {
					exch(a,i,gt);
					gt--;
				}
				else {
					i++;
				}
			}
		sort(a,lo,it-1,d);
		if (pivot>=0) {
			sort(a,it,gt,d+1);
		}
		sort(a,gt+1,hi,d);
	}
	public int lcp(String k,String l)
	{
		int min=Math.min(k.length(),l.length());
		for (int i=0;i<min;i++ ) {
			if (k.charAt(i)!=l.charAt(i)) {
				return i;
			}
		}
		return min;
	}
	public void Longestcommonsubstring()
	{
		String result="";
		for (int i=0;i<a.length ;i++ ) {
			for (int j=0;j<b.length;j++) {
				int len=lcp(a[i],b[j]);
				String m=a[i].substring(0,len);
				if (len>result.length()) {
					result=m;
				}
			}
		}
		System.out.println("Output "+result);
	}
	public static void main(String[] args) {
		// String a="aaaaa";
		// String b="aaaaaaaa";
		String a="mandalivamshikrishna";
		// String b="mvamshiakrishanaaaaa";
		String b="mvamshikrishnaaa";

		longestcommonsubstring q=new longestcommonsubstring(a,b);
		q.Longestcommonsubstring();
	}
}