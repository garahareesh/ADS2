import java.util.*;
class Lsd{
	Lsd()
	{

	}
	public static void sort(char[] a)
	{
		int n=a.length;
		int R=256;
		char[] temp=new char[n];
		int[] count=new int[R+1];
		for(int i=0;i<n;i++)
			count[a[i]+1]++;
		for(int r=0;r<R;r++)
			count[r+1]+=count[r];
		for (int i=0;i<n ;i++ ) 
			temp[count[a[i]]++]=a[i];
		a=Arrays.copyOf(temp,n);
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		String[] a={"acdf","fkuu","hatu","lovu","uuuu","opdf","zbwf","dfdf","bcdf"};
		char[] b={'c','a','b','a','d','b','k','r','i','s','h','n','a'};
		System.out.println(Arrays.toString(b));
		sort(b);
	}
}