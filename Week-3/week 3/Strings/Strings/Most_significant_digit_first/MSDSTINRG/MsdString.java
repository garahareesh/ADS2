import java.util.*;
class MsdString{
	static int R=256;
	public static void sort(String[] a)
	{
		int n=a.length;
		String[] temp=new String[n];
		sort(a,0,n-1,0,temp);
		System.out.println(Arrays.toString(a));
	}
	public static int charAt(String s, int d)
	{
		if(d>=s.length()) return -1;
		return s.charAt(d);
	}
	public static void sort(String[] a, int lo, int hi, int d,String[] temp)
	{
		if(hi<=lo)return;
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
			a[i]=temp[i-lo];
		for(int r=0;r<R;r++)
			sort(a,lo+count[r],lo+count[r+1]-1,d+1,temp);
	}
	public static void main(String[] args) {
		String[] a={"acdfhbhihl","lkhlkhlfkuu","hkhkatu","l","uuuu","opdf","zbwf","dfdf","bcdf"};
		//char[] b={'c','a','b','a','d','b','k','r','i','s','h','n','a'};
		System.out.println(Arrays.toString(a));
		sort(a);
	}
}