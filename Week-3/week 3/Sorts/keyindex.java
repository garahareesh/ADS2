import java.util.*;
class keyindex
{	
	public void keyind(char a[])
	{
		int n=a.length;
		int R=256;
		char aux[]=new char[n];
		int count[]=new int[R+1];
		for(int i=0;i<n;i++)
		{
			count[a[i]+1]++;
		}
		System.out.println(Arrays.toString(count));
		for(int r=0;r<R;r++)
		{
			count[r+1]+=count[r];
		}
		for(int i=0;i<n;i++)
		{
			aux[count[a[i]]++]=a[i];
		}
		for(int i=0;i<n;i++)
		{
			a[i]=aux[i];
		}
		// System.out.println(Arrays.toString(count));
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		keyindex k=new keyindex();
		char s[]={'f','a','h','d','k','h','f'};
		k.keyind(s);
	}
}