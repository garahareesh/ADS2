import java.util.*;
class MSD
{
	String a[],aux[];
	int n,R=256;
	int cutOff=3;
	public MSD(String k[])
	{
		a=k;
		n=a.length;
		aux=new String[n];
	}
	public int charAt(String s,int d)
	{
		if(d==s.length())
		{
			return -1;
		}
		return (int)s.charAt(d);
	}
	public void sort()
	{
		sort(a,aux,0,a.length-1,0);
	}
	public void sort(String a[],String aux[],int lo,int hi,int d)
	{
		if(hi<=lo+cutOff)
		{
			System.out.println("kkkkb");
			insertion(a,lo,hi,d);
			return;
		}
		int count[]=new int[R+2];
		if (lo>=hi) {
			return;
			
		}
		for(int i=lo;i<=hi;i++)
		{
			count[charAt(a[i],d)+2]++;
		}
		//System.out.println("==============================================================");
		//System.out.println(Arrays.toString(count));
		//System.out.println("///////////////////////////////////////////////////////////////");
		for(int j=0;j<R+1;j++)
		{
			count[j+1]+=count[j];
		}
		//System.out.println("------------------------------------------------------------------");
		//System.out.println(Arrays.toString(count));
		for(int i=lo;i<=hi;i++)
		{
			aux[count[charAt(a[i],d)+1]++]=a[i];
		}
		for(int i=lo;i<=hi;i++)
		{
			a[i]=aux[i-lo];
		}
		//System.out.println(Arrays.toString(a));
		//System.out.println("*************************************************************************");
		for(int j=0;j<R;j++)
		{
			sort(a,aux,lo+count[j],lo+count[j+1]-1,d+1);
		}

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
        
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
	public void display()
	{
		System.out.println("out");
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		String a[]={"cap","bca","map","ab","aab","aaabc","aaaaaa","a"};
		// String a[]={"vamshi","krishna","is","god"};loed/
		MSD s=new MSD(a);
		s.sort();
		s.display();
	}
}