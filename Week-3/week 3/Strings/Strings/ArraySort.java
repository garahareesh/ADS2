import java.util.*;
class ArraySort
{
	public static void sort(int[][] s)
	{
		sort(s,0,s.length-1,0);
	}
	public static int charAt(int[] s, int d)
	{
		if(d<s.length)
			return s[d];
		return -1;
	}
	public static void sort(int[][] s,int l, int h, int d)
	{
		if(l>=h)
			return;
		int lt = l;
		int gt = h;
		int i = lt+1;
		int v = charAt(s[lt],d);
		while(i<=gt)
		{
			int t = charAt(s[i],d);
			if(t<v)
				exch(s,i++,lt++);
			else if(t>v)
				exch(s,i,gt--);
			else
				i++;
		}
		sort(s,l,lt-1,d);
		sort(s,lt,gt,d+1);
		sort(s,gt+1,h,d);
	}
	public static void exch(int[][] s, int x, int y)
	{
		int[] temp = s[x];
		s[x] = s[y];
		s[y] = temp;
	}
	public static void main(String[] args)
	{
		int[][] arr = {{5,2,7},{-2,7,9},{-2,9,9},{-2,-2,9},{-3,9,9},{1,1,1}};
		sort(arr);
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(Arrays.toString(arr[i]));
		}	
	}
}