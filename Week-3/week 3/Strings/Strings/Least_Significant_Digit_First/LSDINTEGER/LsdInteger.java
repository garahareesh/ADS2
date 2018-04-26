import java.util.*;
class LsdInteger{
	public static void sort(int[] a)
	{
		int bits=32;
		int bits_per_bytes=8;
		int R=1<<bits_per_bytes;
		int mask=R-1;
		int w=bits/bits_per_bytes;
		int n=a.length;
		int[] temp=new int[n];
		for(int d=0;d<w;d++)
		{
			int[] count=new int[R+1];
			for(int i=0;i<n;i++)
			{
				int c=(a[i]>>bits_per_bytes*d)&mask;
				count[c+1]++;
			}
			for(int r=0;r<R;r++)
				count[r+1]+=count[r];
			if(d==w-1)
			{
				int shift1=count[R]-count[R/2];
				int shift2=count[R/2];
				for(int r=0;r<R/2;r++)
					count[r]+=shift1;
				for(int r=R/2;r<R;r++)
					count[r]-=shift2;
			}
			for(int i=0;i<n;i++)
			{
				int c=(a[i]>>bits_per_bytes*d)&mask;
				temp[count[c]++]=a[i];
			}
			a=Arrays.copyOf(temp,n);
		}
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		int[] a={5,-12,35675,2,45,23,564};
		//char[] b={'c','a','b','a','d','b','k','r','i','s','h','n','a'};
		System.out.println(Arrays.toString(a));
		sort(a);
	}
}