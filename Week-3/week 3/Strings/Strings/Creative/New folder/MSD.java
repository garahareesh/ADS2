import java.util.*;
class MSD
{
	String a[];
	String aux[];
	int cutoff;
	public MSD(String []a,int cutoff)
	{
		this.a=a;
		this.cutoff=cutoff;
		aux=new String[a.length];
		msd(a,0,a.length-1,0,aux);
	}
	public int charAt(String s,int d)
	{
		if(d==s.length())
			return -1;
		else
			return s.charAt(d);
	}
	public void swap(String []a,int i,int j)
	{
		String temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public void quicksort(String a[],int lo,int hi,int d)
	{
		if(hi<=lo)
			return;
		int v=charAt(a[lo],d);
		int lt=lo;
		int gt=hi;
		int i=lo+1;
		
		while(i<=gt)
		{
			int t=charAt(a[i],d);
			if(t<v)
			{
				swap(a,lt,i);
				i++;
				lt++;
			}
			else if(t>v)
			{
				swap(a,gt,i);
				gt--;
			}
			else
			{
				i++;
			}
		}
		quicksort(a,lo,lt-1,d);
		if(v>=0)
		{
			quicksort(a,lt,gt,d+1);
		}
		quicksort(a,gt+1,hi,d);
	}
	public void msd(String []a,int lo,int hi,int d,String []aux)
	{
		int R=256;
		if(hi<=lo+cutoff)
		{
			quicksort(a,lo,hi,d);
			return;
		}
		else
		{
			int count[]=new int[R+2];
			for(int i=lo;i<=hi;i++)
			{
				int c=charAt(a[i],d);
				count[c+2]++;
			}
			for(int j=0;j<R+1;j++)
			{
				count[j+1]+=count[j];
			}
			for(int i=lo;i<=hi;i++)
			{
				int c=charAt(a[i],d);
				aux[count[c+1]++]=a[i];
			}
			for(int i=lo;i<=hi;i++)
			{
				a[i]=aux[i-lo];
			}
			for(int k=0;k<R+1;k++)
			{
				msd(a,lo+count[k],lo+count[k+1]-1,d+1,aux);
			}
		}
		
	}
	public static void main(String []args)
	{
		String a[]={"naresh","nares","pratik"};
		String b[]={"no","is","th","ti","fo","al","go","pe","to","co","to","th","ai","of","th","pa"};
		MSD m=new MSD(b,2);
		System.out.println(Arrays.toString(b));
	}
}