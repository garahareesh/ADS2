import java.util.*;
class Way3Quick
{
	String a[];
	// int cutOff=3;
	Way3Quick(String k[])
	{
		a=k;

	}
	public void sort()
	{
		sort(a,0,a.length-1,0);
	}
	public int charAt(String s,int d)
	{
		if(d==s.length())
		{
			return -1;
		}
		return s.charAt(d);
	}
	public void sort(String[] a,int lo,int hi,int d)
	{
		if(hi<=lo)
		{
			return;
		}
		// if(hi<=lo+cutOff)
		// {
		// 	insertion(a,lo,hi,d);
		// 	return;
		// }
		int lt=lo,gt=hi;
		int v=charAt(a[lo],d);
		int i=lo+1;
		while(i<=gt)
		{
			int t=charAt(a[i],d);
			if(t<v)
			{
				// System.out.println("lt..+"+lt+" "+i);
				exch(a,lt++,i++);
			}
			else if(t>v)
			{
				// System.out.println("i..."+i+"  "+"gt.."+gt);
				exch(a,i,gt--);
			}
			else
			{
				i++;
			}
			System.out.println(Arrays.toString(a));
		}
			sort(a,lo,lt-1,d);
			if(v>=0)
			{
				sort(a,lt,gt,d+1);
			}
			sort(a,gt+1,hi,d);
		
	}
	public void insertion(String[] a,int lo,int hi,int d)
	{
		for(int i=lo;i<=hi;i++)
		{
			for(int j=i;j>lo && less(a[j],a[j-1],d);j--)
			{
				exch(a,j,j-1);
			}
		}
	}
	private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
     private static boolean less(String v, String w, int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
    public void display()
	{
		// System.out.println("out");
		System.out.println(Arrays.toString(a));
	}
    public static void main(String[] args) {
    	String a[]={"xrf","asd","mnv","ijh"};
    	Way3Quick al=new Way3Quick(a);
    	al.sort();
		al.display();
    }
	
}