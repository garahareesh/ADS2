import java.util.*;
class LSDALPHA
{
	String a[],aux[];
	int n,w;
	public LSDALPHA(String k[])
	{
		a=k;
		n=a.length;
		w=a[0].length();
		aux=new String[n];
	}
	public void lsd(String a[])
	{
		for(int d=w-1;d>=0;d--)
		{
			int count[]=new int[53];
			for(int i=0;i<n;i++)
			{
				if(97<=a[i].charAt(d) && a[i].charAt(d)<=122)
				  		count[(a[i].charAt(d)+1)-97+26]++;
				else{
					// System.out.println(".............");
						count[(a[i].charAt(d)+1)-65]++;
					}
			}
			// System.out.println("Count "+Arrays.toString(count));
			for(int j=0;j<52;j++)
			{
				count[j+1]+=count[j];
			}
			// System.out.println("Count "+Arrays.toString(count));
			// System.out.println("********************************************************************");
			for(int i=0;i<n;i++)
			{
				if(97<=a[i].charAt(d) && a[i].charAt(d)<=122)
				  aux[count[(a[i].charAt(d)-97+26)]++]=a[i];
				else{
					// System.out.println(",,,,,,,,,,,,,,");
					aux[count[(a[i].charAt(d)-65)]++]=a[i];
				}
				// System.out.println("Count "+Arrays.toString(count));
				// System.out.println("--------------------------------------------------------------------");
				// System.out.println(Arrays.toString(aux));
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
		String a[]={"Sea","abc","saw","pop","see","map","app","cap"};
		LSDALPHA s=new LSDALPHA(a);
		s.display();
		s.lsd(a);
		s.display();
	}
	
}