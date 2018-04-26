//implement msd sort
import java.util.*;
public class MSD
{
	int [] count;
	String [] aux;
	// int cut_off;
	int n;
	String [] arr;
	int R;
	public MSD(String [] a)
	{
		this.R=256;
		// cut_off=c;
		n=a.length;
		aux=new String[n];
		this.arr=a;
		sort(arr,aux,0,n-1,0);
	}
	public int charAt(String a,int d)
	{
		if(d==a.length()) return -1;
		return a.charAt(d);
	}
	public void sort(String [] a, String [] aux,int lo,int hi,int d)
	{
		// if(hi<=lo+cut_off)
		// {
		// 	insertionSort(a,lo,hi,d);
		// 	return ;
		// }
		if(hi<=lo) return ;
		count=new int[R+2];
		for(int i=lo;i<=hi;i++)
		{
			count[charAt(a[i],d)+2]++;
		}
		for(int r=0;r<R+1;r++)
		{
			count[r+1]+=count[r];
		}
		for(int i=lo;i<=hi;i++)
		{
			aux[count[charAt(a[i],d)+1]++]=a[i];
		}
		for(int i=lo;i<=hi;i++)
		{
			a[i]=aux[i-lo];
		}
		this.arr=a;
		for(int r=0;r<R;r++)
		{
			sort(a,aux,lo+count[r],lo+count[r+1]-1,d+1);
		}

	}
	public void insertionSort(String[] a,int lo,int hi,int d)
	{
		for(int i=lo;i<=hi;i++)
		{
			for(int j=i;j>lo && less(a[j],a[j-1],d);j--)
				exch(a,j,j-1);
		}
	}
	public void exch(String [] k,int i,int j)
	{
		String temp=k[i];
		k[i]=k[j];
		k[j]=temp;
	}
	public boolean less(String v, String w,int d)
	{
		int min=Math.min(v.length(),w.length());
		for(int i=d;i<min;i++)
		{
			if(v.charAt(i)<w.charAt(i)) return true;
			if(v.charAt(i)>w.charAt(i)) return false;
		}
		return v.length()<w.length();
	}
	public void display()
	{
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		String [] a={"fee","tap","tar","wad","was"};
		MSD ob=new MSD(a);
		ob.display();
	}
}