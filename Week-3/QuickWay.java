//implement QuickWaysort
import java.util.*;
public class QuickWay
{
	String [] a;
	int n;
	QuickWay(String [] a)
	{
		this.a=a;
		n=a.length;
		sort(a,0,n-1,0);
	}
	public int charAt(String b, int c)
	{
		if(c==b.length())return -1;
		return b.charAt(c);
	}
	public void sort(String[] a, int lo, int hi, int d)
	{
		if(hi<=lo) return ;
		int lt=lo,gt=hi;
		int v=charAt(a[lo],d);
		int i=lo+1;
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
			else{
				i++;
			}
			// System.out.println(Arrays.toString(a));
		}
		sort(a,lo,lt-1,d);
		if(v>=0) sort(a,lt,gt,d+1);
		sort(a,gt+1,hi,d);
	}
	public void exch(String [] z,int i,int j)
	{
		String temp=z[i];
		z[i]=z[j];
		z[j]=temp;
	}
	public void display()
	{
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		String [] a={"mississippi", "ississippi", "ssissippi", "sissippi", "issippi", "ssippi", "sippi", "ippi", "ppi", "pi", "i","issi"};

		QuickWay ob=new QuickWay(a);
		ob.display();
	}
}