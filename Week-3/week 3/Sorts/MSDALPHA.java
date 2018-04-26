import java.util.*;
class MSDALPHA
{
	String a[],aux[];
	int n,R=53;
	
	public MSDALPHA(String k[])
	{
		a=k;
		n=a.length;
		aux=new String[k.length];
	}
	public int charAt(String s,int d){
		if(d<s.length()){
			int x=s.charAt(d);
			if(x>=65 && x<=90){
				return (x-65);
			}else if(x>=97 && x<=122){
				return (x-97)+26;
			}
		}	
		return -1;
	}	
	public void sort()
	{
		sort(a,aux,0,a.length-1,0);
	}
	public void sort(String a[],String aux[],int lo,int hi,int d)
	{
		
		int count[]=new int[R+2];
		if (lo>=hi) {
			return;
			
		}
		for(int i=lo;i<=hi;i++)
		{
			count[charAt(a[i],d)+2]++;
		}
		//System.out.println("==============================================================");
		//System.out.println(Arrays.toString(count));
		//System.out.println("///////////////////////////////////////////////////////////////");
		for(int j=0;j<R+1;j++)
		{
			count[j+1]+=count[j];
		}
		//System.out.println("------------------------------------------------------------------");
		//System.out.println(Arrays.toString(count));
		for(int i=lo;i<=hi;i++)
		{
			aux[count[charAt(a[i],d)+1]++]=a[i];
		}
		for(int i=lo;i<=hi;i++)
		{
			a[i]=aux[i-lo];
		}
		//System.out.println(Arrays.toString(a));
		//System.out.println("*************************************************************************");
		for(int j=0;j<R;j++)
		{
			sort(a,aux,lo+count[j],lo+count[j+1]-1,d+1);
		}

	}
	
     
	public void display()
	{
		System.out.println("out");
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		String a[]={"cap","bca","map","ab","aab","aaabc","aaaaaa","a"};
		// String a[]={"vamshi","krishna","is","god"};loed/
		MSDALPHA s=new MSDALPHA(a);
		s.sort();
		s.display();
	}
}