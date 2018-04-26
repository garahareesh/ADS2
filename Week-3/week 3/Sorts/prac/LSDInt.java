import java.util.*;
class LSDInt
{
	int[] am;
	LSDInt(int[] a)
	{
		am=a;
		int bits=32;
		int bitspersec=8;
		int w=bits/bitspersec;
		int r=1<<bitspersec;
		int mask=r-1;
		int[] aux=new int[a.length];
		for(int d=0;d<w;d++)
		{
			int[] count=new int[r+1];
			for(int i=0;i<a.length;i++)
			{
				int temp=(a[i]>>bitspersec*d)&mask;
				count[temp+1]++;
			}
		
		for(int j=0;j<r;j++)
		{
			count[j+1]+=count[j];
		}
		if(d==w-1)
		{
			int shift1=count[r]-count[r/2];
			int shift2=count[r/2];
			for(int j=0;j<r/2;j++)
			{
				count[j]+=shift1;
			}
			for(int j=r/2;j<r;j++)
			{
				count[j]-=shift2;
			}
		}
		for (int i=0;i<a.length ;i++ ) {
			int tem=(a[i]>>bitspersec*d)&mask;
			aux[count[tem]++]=a[i];
			
		}
		for (int i=0;i<a.length ;i++ ) {
				am[i]=aux[i];
			}
	}
}
public void display()
	{
		System.out.println(Arrays.toString(am));
	}
	public static void main(String[] args) {
		
		int a[]={1280, -979, 6, 180, 256, -2, 01,-98};
		LSDInt q=new LSDInt(a);
		// q.(a);
		q.display();
	}
	
}