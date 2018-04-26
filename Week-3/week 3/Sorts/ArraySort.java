import java.util.*;
class ArraySort
{
	public void sort(int a[][])
	{
		sort(a,0,a.length-1,0);
	}
	public int charAt(int a[],int d)
	{
		if(d==a.length)
		{
			return -1;
		}
		return a[d];
	}
	public void sort(int a[][],int lo,int hi,int d)
	{
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
				exchange(a,i++,lt++);
			}
			else if(t>v)
			{
				exchange(a,i,gt--);
			}
			else
			{
				i++;
			}
		}
		sort(a,lo,lt-1,d);
		sort(a,lt,gt,d+1);
		sort(a,gt+1,hi,d);
	}
	public static void exchange(int[][] s, int x, int y)
	{
		int[] temp = s[x];
		s[x] = s[y];
		s[y] = temp;
	}
	public static void main(String[] args)
	{
		ArraySort a=new ArraySort();
		int[][] arr = {{5,2,7},{-2,7,9},{-2,9,9},{-2,-2,9},{-3,9,9},{1,1,1}};
		a.sort(arr);
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(Arrays.toString(arr[i]));
		}	
	}
}