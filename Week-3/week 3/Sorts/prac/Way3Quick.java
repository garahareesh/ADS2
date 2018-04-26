import java.util.*;
class Way3Quick
{
	String[] a;
	Way3Quick(String[] k)
	{
		a=k;
	}
	public int charAt(String s,int d)
	{
		if(d==s.length())
		{
			return -1;
		}
		return s.charAt(d);
	}
	public void sort()
	{
		sort(a,0,a.length-1,0);
	}
	public void sort(String[] a,int lo,int hi,int d)
	{
		if(lo>=hi)
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
			if(v>=0) sort(a,lt,gt,d+1);
			sort(a,gt+1,hi,d);
		
	}
	public void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
     public void display()
	{
		System.out.println("out");
		System.out.println(Arrays.toString(a));
	}
    public static void main(String[] args) {
    	String a[]={"cap","bca","map","ab","aab","aaabc","aaaaaa","a"};
    	Way3Quick al=new Way3Quick(a);
    	al.sort();
		al.display();
    }
}