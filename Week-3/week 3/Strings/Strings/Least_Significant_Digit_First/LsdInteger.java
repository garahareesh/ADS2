import java.util.*;
class LsdInteger{
	public static void sort(int[] a)
	{
		int bits=32;
		int bits_per_byte=8;
		int R=1<<bits_per_byte;
		int mask=R-1;
		int w=bits/bits_per_byte;
		int n=a.length;
		int[] temp=new int[n];
		for(int d=0;d<w;d++)
		{
			int[] count=new int[R+1];
			for(int i=0;i<n;i++)
			{
				int c=(a[i]>>bits_per_byte*d)&mask;
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
			for(int i=0;i<n;i++){
				int c=(a[i]>>bits_per_byte*d)&mask;
				temp[count[c]++]=a[i];
			}
			a=Arrays.copyOf(temp,n);
		}
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		int[] a={12,145,34,0,56,22,-45,127,-15,-12214,456405,500000};
		//char[] b={'c','a','b','a','d','b','k','r','i','s','h','n','a'};
		System.out.println(Arrays.toString(a));
		sort(a);
	}
}