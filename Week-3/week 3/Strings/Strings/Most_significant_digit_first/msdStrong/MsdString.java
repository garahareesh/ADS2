import java.util.*;
class msdStirng{
	static int R=1<<8;
	public static String[] sort(String[] a)
	{
		int n=a.length;
		String[] temp=new String[n];
		sort(a,0,n-1,0,temp);
		return a;
	}
	public static int charAt(String s,int d)
	{
		assert d>=0&&d<=s.length();
		if(d==s.length()) return -1;
		return s.charAt(d);
	}
	public static void sort(String[] a,int lo,int hi,int d,String[] temp)
	{
		if(hi<=lo) return;
		int[] count=new int[R+2];
		for(int i=lo;i<=hi;i++)
		{
			int c=charAt(a[i],d);
			if(97<=c&&c>=122)
				count[(c+2)-97+26]++;
			else if(c!=-1) count[(c+2)-65]++;
		}
		for(int r=0;r<R+1;r++)
			count[r+1]+=count[r];
		for(int i=lo;i<=hi;i++)
		{
			int c=charAt(a[i],d);
			//temp[count[c+1]++]=a[i];
			if(97<=c&&c>=122)
			temp[count[(c+1)-97+26]++]=a[i];
			else if(c!=-1) temp[count[(c+1)-65]++]=a[i];
		}
		for(int i=lo;i<=hi;i++)
			a[i]=temp[i-lo];
		for(int r=0;r<R;r++)
			sort(a,lo+count[r],lo+count[r+1]-1,d+1,temp);
	}
	public static void main(String[] args) {
		// String[] a={"xxdfhbhihl","lkhlkhlfkuu","hkhkatu","l","asd","uuuu","opdf","zbwf","dfdf","bcdf"};
		//char[] b={'c','a','b','a','d','b','k','r','i','s','h','n','a'};
		String[] a={"aa","aaa","aaaa","AA","Abc","Bcdd","A"};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(sort(a)));
	}
}