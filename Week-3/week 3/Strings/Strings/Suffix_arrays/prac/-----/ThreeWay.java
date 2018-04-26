import java.util.*;
class ThreeWay
{
	String[] a;
	int cutoff=1;
	
	ThreeWay(String[] a)
	{
		this.a=a;

	}
	public void sort()
	{
		sort(a,0,a.length-1,0);
	}
	public int charAt(String s,int d)
	{
		if(s.length()==d)
		{
			return -1;
		}
		return (int)s.charAt(d);
	}
	public void sort(String[] a,int lo,int hi,int d)
	{
		if(hi<=lo+cutoff)
		{
			insertion(a,lo,hi,d);
			return;
		}
		if(hi<=lo)
		{
			return;
		}
		int lt=lo;
		int gt=hi;
		int i=lo+1;
		int v=charAt(a[lo],d);
		while(i<=gt)
		{
			int t=charAt(a[i],d);
			if(t<v)
			{
				exch(a,lt++,i++);
			}
			else if(t>v)
			{
				exch(a,i,gt--);
			}
			else
			{
				i++;
			}
		}
		sort(a,lo,lt-1,d);
		if(v>=0)
		{
			sort(a,lt,gt,d+1);
		}
		sort(a,gt+1,hi,d);

	}
	public void exch(String[] a,int i,int j)
	{
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public void insertion(String[] a,int lo,int hi,int d )
	{
		for(int i=lo;i<=hi;i++)
		{
			for (int j=i;j>lo && less(a[j],a[j-1],d) ;j-- ) {
				exch(a,j,j-1);
				
			}
		}
	}
	public boolean less(String v,String w,int d)
	{
		for(int i=d;i<Math.min(v.length(),w.length());i++)
		{
			if(v.charAt(i)<w.charAt(i)) return true;
			if(v.charAt(i)>w.charAt(i)) return false;
		}
		return v.length()<w.length();
	}
	 public void display()
	{
		System.out.println("out");
		System.out.println(Arrays.toString(a));
	}
    public static void main(String[] args) {
    	String a[]={"cap","bca","map","ab","aab","aaabc","aaaaaa","a"};
    	ThreeWay al=new ThreeWay(a);
    	al.sort();
		al.display();
    }
}