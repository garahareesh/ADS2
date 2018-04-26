import java.util.*;
class LsdStrings{
	public static void sort(String[] a,int w)
	{
		int R=256;
		int n=a.length;
		String[] temp=new String[n];
		for(int d=w-1;d>=0;d--)
		{
			int[] count=new int[R+1];
			for(int i=0;i<n;i++)
				count[a[i].charAt(d)+1]++;
			for(int r=0;r<R;r++)
				count[r+1]+=count[r];
			for(int i=0;i<n;i++)
				temp[count[a[i].charAt(d)]++]=a[i];
			a=Arrays.copyOf(temp,n);
		
		}
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		String[] a={"acdf","fkuu","hatu","lovu","uuuu","opdf","zbwf","dfdf","bcdf"};
		//char[] b={'c','a','b','a','d','b','k','r','i','s','h','n','a'};
		System.out.println(Arrays.toString(a));
		sort(a,4);
	}
}