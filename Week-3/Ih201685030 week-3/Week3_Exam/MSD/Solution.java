import java.util.*;
public class Solution{
	int R=256;
	String[] a;
	// int [] count;
	String[] aux;
	Solution(String[] a)
	{
		this.a=a;
		aux=new String[a.length];
		int len=aux.length;
		sort(a,0,len-1,0);
	}

	public int charAt(String s,int d)
	{
		if(d<s.length())
			return s.charAt(d);
		else
			return -1;
	}


	void sort(String[] a,int lo,int hi,int d){
		if(hi<=lo)
		{
			return;
		}
		int [] count= new int[R+2];
		for(int i=lo;i<=hi;i++)
		{
			count[charAt(a[i],d)+2]++;
		}

		for(int r=0;r<R+1;r++)
		{
			count[r+1]+=count[r];
		}
		for(int i=lo;i<=hi;i++)
		{
			aux[count[charAt(a[i],d)+1]++]=a[i];
		}
		for(int i=lo;i<=hi;i++)
		{
			a[i]=aux[i-lo];
		}

		for(int r=0;r<R;r++)
		{
			sort(a,lo+count[r],lo+count[r+1]-1,d+1);
		}
	}



	String display()
	{
		String str="";
		for(int i=0;i<a.length;i++)
		{
			str+=a[i]+",";

		}
		return str.substring(0,str.length()-1);

	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		int testcases= Integer.parseInt(sc.nextLine());
		for(int i=0;i<testcases;i++)
		{
			String str=sc.nextLine();

			String[] as=str.split(",");
			Solution obj= new Solution(as);
			System.out.println(obj.display());


		}
	}
}











