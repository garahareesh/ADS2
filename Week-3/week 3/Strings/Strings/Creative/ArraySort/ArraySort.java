import java.util.*;
class ArraySort{
	public static void sort(int[][] arr)
	{
		sort(arr,0,arr.length-1,0);
	}
	public static int charAt(int[] s,int d)
	{
		if(d>=s.length) return -1;
		return s[d];
	}
	public static void sort(int[][] arr, int lo, int hi,int d)
	{
		if(hi<=lo) return;
		int lt=lo;
		int gt=hi;
		int i=lo+1;
		int v=charAt(arr[lo],d);
		while(i<=gt)
		{
			int t=charAt(arr[i],d);
			if(t<v) exch(arr,i++,lt++);
			else if(t>v) exch(arr,i,gt--);
			else i++;
		}
		sort(arr,lo,lt-1,d);
		sort(arr,lt,gt,d+1);
		sort(arr,gt+1,hi,d);		
	}
	public static void exch(int[][] arr, int i, int j)
	{
		int[] temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String[] args) {
		int[][] arr = {{5,2,7},{-2,7,9},{-2,9,9},{-2,-2,9},{-3,9,9},{1,1,1}};
		sort(arr);
		for(int i=0; i<arr.length; i++)
		{
			System.out.println(Arrays.toString(arr[i]));
		}	
	}
}