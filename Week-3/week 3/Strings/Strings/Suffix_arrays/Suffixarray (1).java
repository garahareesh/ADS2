import java.util.*;
import java.io.*;
class Suffixarray
{
	String a[];
	int n;
	String s;
	ArrayList <String>al;
	Map <String,Integer>m;
	public Suffixarray(String k)
	{
		s=k;
		al=new ArrayList <String>();
		n=s.length();
		a=new String[n];
		m=new HashMap <String,Integer>();
		for (int i=0;i<n ;i++ ) {
			a[i]=s.substring(i,n);
		}
		sort();
		for (int j=0;j<a.length;j++) {
			m.put(a[j],0);
		}
	}
	public void sort()
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
	public void exch(int i,int j)
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
					exch(i,it);
					i++;
					it++;
				}
				else if (t>pivot) {
					exch(i,gt);
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
	public void lcp(String a,String b)
	{
		int l1=a.length(),min;
		int l2=b.length();
		if (l1>l2) {
			min=l2;
		}
		else {
			min=l1;
		}
		for (int i=0;i<min;i++) {
			if (a.charAt(i)!=b.charAt(i)) {
				return ;
			}
		}
		if (min==l1) {
			int v=m.get(a);
			v=v+1;
			m.put(a,v);
		}
		else {
			int v2=m.get(b);
			v2=v2+1;
			m.put(b,v2);
		}
	}
	public void krepeated(int k)
	{
		//System.out.println("sorted array "+Arrays.toString(a));
		for (int i=0;i<a.length;i++) {
			for (int j=i+1;j<a.length;j++) {
				lcp(a[i],a[j]);
			}
		}
		System.out.println("Map "+m);
		System.out.println("abcd "+m.get("abcd"));
		for (int i=0;i<a.length ;i++ ) {
			String s=a[i];
			if (m.get(s)>=k) {
				al.add(s);
			}

			// if(m.get(s)>=1&&s.length()>=k)
			// 	al.add(s);
		}
		System.out.println("output "+al);
	}
	public static void main(String[] args) {
		String s="abcdbcabcdefghdefaaaabcde";
		Suffixarray q=new Suffixarray(s);
		//System.out.println(Arrays.toString(q.a));
		q.krepeated(2);
	}
}