import java.util.*;
class LSDAlpha
{
	String[] a,aux;
	int n;
	int w;
	int R=52;
	LSDAlpha(String[] k)
	{
		a=k;
		 n=k.length;
		 w=a[0].length();
		 aux=new String[n];
	}
	public void LSDAlpha(String[] a)
	{
		for(int d=w-1;d>=0;d--)
		{
			int[] count=new int[R+1];
		for(int i=0;i<n;i++)
		{
			
			if(97<=a[i].charAt(d) && a[i].charAt(d)<=122)
			{
				count[(a[i].charAt(d)+1)-97+26]++;
			}
			else
			{
				count[(a[i].charAt(d)+1)-65]++;
			}
		}
		for(int j=0;j<52;j++)
		{
			count[j+1]+=count[j];
		}
		for(int i=0;i<n;i++)
		{
			if(97<=a[i].charAt(d) && a[i].charAt(d)<=122)
				  aux[count[(a[i].charAt(d)-97+26)]++]=a[i];
				else{
					// System.out.println(",,,,,,,,,,,,,,");
					aux[count[(a[i].charAt(d)-65)]++]=a[i];
				}
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
		LSDAlpha s=new LSDAlpha(a);
		s.display();
		s.LSDAlpha(a);
		s.display();
	}
	
	
}