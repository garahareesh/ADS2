//implement Key indexed frequency
import java.util.*;
public class KeyIndex
{
	char [] a;
	int [] count;
	char [] aux;
	int R;
	int n;
	public KeyIndex(char []a)
	{
		this.a=a;
		R=256;
		count=new int[R+1];
		aux=new char[a.length];
		
		n=a.length;
		for(int i=0;i<n;i++)
		{
			count[a[i]+1]++;
		}
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
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		char[] a={'Z','a','x','r','P','k'};
		KeyIndex ob=new KeyIndex(a);
	}
}