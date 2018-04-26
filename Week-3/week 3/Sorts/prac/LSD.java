import java.util.*;
class Lsd
{
	String[] a,aux;
	int R=256;
	int n,w;
	Lsd(String[] s)
	{
		a=s;
		 n=s.length;
		 w=a[0].length();
		 aux=new String[n];

	}
	public void Lsd()
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
		Lsd s=new Lsd(a);
		s.display();
		s.Lsd();
		s.display();
	}
}