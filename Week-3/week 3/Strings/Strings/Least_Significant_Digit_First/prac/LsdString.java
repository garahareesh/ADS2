import java.util.*;
class LsdString{
	public static void sort(String[] a,int w)
	{
		int n=a.length;
		int R=256;
		String[] temp=new String[n];
		for(int d=w-1;d>=0;d--)
		{
			System.out.println(d);
			int[] count=new int[R+1];
			for(int i=0;i<n;i++)
				count[a[i].charAt(d)+1]++;
			for(int r=0;r<R;r++)
				count[r+1]+=count[r];
			for(int i=0;i<n;i++)
				temp[count[a[i].charAt(d)]++]=a[i];
			a=Arrays.copyOf(temp,n);
			System.out.println(Arrays.toString(a));
		}
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		String[] a={"4PGC938","2IYE230","3CIO720","1ICK750","1OHV845","4JZY524","1ICK750","3CIO720","1OHV845","1OHV845","2RLA629","2RLA629","3ATW723"};
		sort(a,7);
		//System.out.println(Arrays.toString(a));
	}
}