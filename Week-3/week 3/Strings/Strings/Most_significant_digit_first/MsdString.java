import java.util.*;
class MsdString{
	static int R=1<<8;
	public static void sort(String[] a)
	{
		int n=a.length;
		String[] temp=new String[n];
		sort(a,0,n-1,0,temp);
		System.out.println(Arrays.toString(a));
		for(int i=0;i<a.length-1;i++){
			if(a[i].compareTo(a[i+1])>0)
				System.out.println("failed");
		}
		System.out.println("passed");
	}
	public static int charAt(String s,int d)
	{
		assert d>=0&&d<=s.length();
		if(d==s.length()) return -1;
		return s.charAt(d);
	}
	public static void sort(String[] a,int lo,int hi,int d,String[] temp)
	{
		if(hi<=lo)
		{
			return;
		}
		int[] count=new int[R+2];
		for(int i=lo;i<=hi;i++)
		{
			int c=charAt(a[i],d);
			count[c+2]++;
		}
		for(int r=0;r<R+1;r++)
			count[r+1]+=count[r];
		for(int i=lo;i<=hi;i++)
		{
			int c=charAt(a[i],d);
			temp[count[c+1]++]=a[i];
		}
		for(int i=lo;i<=hi;i++)
		{
			a[i]=temp[i-lo];
		}
		for(int r=0;r<R;r++)
			sort(a,lo+count[r],lo+count[r+1]-1,d+1,temp);
	}
	// public static void insertionSort(String[] a,int lo,int hi,int d)
	// {
	// 	for(int i=lo+1;i<=hi;i++)
	// 	{
	// 		for(int j=i;j>lo&&less(a[j],a[j-1],d);j--)
	// 			exch(a,j,j-1);
	// 	}
	// }
	public static void main(String[] args) {
		String[] a={"acdfhbhihl","lkhlkhlfkuu","hkhkatu","l","uuuu","opdf","zbwf","dfdf","bcdf"};
		//char[] b={'c','a','b','a','d','b','k','r','i','s','h','n','a'};
		System.out.println(Arrays.toString(a));
		sort(a);
	}
}