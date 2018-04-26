//implement lsd sort
import java.util.*;
public class LSD
{
	String [] a;
	int [] count;
	int w;
	int R;
	String [] aux;
	public LSD(String [] a)
	{
		this.a=a;
		R=256;		
		w=a[0].length();
		int n=a.length;
		aux=new String[a.length];
		for(int d=w-1;d>=0;d--)
		{
			count=new int[R+2];
			for(int i=0;i<n;i++)
			{
				count[a[i].charAt(d)+1]++;
			}
			for(int r=0;r<R;r++)
			{
				count[r+1]+=count[r];
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
		System.out.println(Arrays.toString(a));
	}	
	public static void main(String[] args) {
		// String [] a={"asd","qwe","zxc","ghj","jkl","iop"};
		Scanner sc=new Scanner(System.in);
		String [] k=new String[100];
		int j=0;
		int no=Integer.parseInt(sc.nextLine());
		for(int l=0;l<no;l++){
		String str=sc.nextLine();
		
		String [] ss=str.split(" ");
		for(int i=0;i<ss.length;i++)
			k[j++]=ss[i];
		}
		String [] re=new String[j];
		for(int i=0;i<j;i++)
		{
			re[i]=k[i];
		}
		LSD ob=new LSD(re);
	}
}