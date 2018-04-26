import java.util.*;
class LSD
{
	String[] a,aux;
	int n,w;
	int R=256;
	public LSD(String[] k)
	{
		this.a=k;
		n=a.length;
		w=a[0].length();
		aux=new String[n];
	}
	public void Lsd(String[] a)
	{
		for(int d=w-1;d>=0;d--)
		{
			int[] count=new int[R+1];
			for(int i=0;i<n;i++)
			{
				count[a[i].charAt(d)+1]++;

			}
			for(int j=0;j<R;j++)
			{
				count[j+1]+=count[j];
			}
			for(int i=0;i<n;i++)
			{
				aux[count[a[i].charAt(d)]++]=a[i];
			}
			for(int i=0;i<n;i++)
			{
				a[i]=aux[i];
			}
		}
	}
	public void display()
	{
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		String a[]={"sea","abc","saw","pop","see","map","app","cap"};
		LSD s=new LSD(a);
		s.display();
		s.Lsd(a);
		s.display();
	}
	
}