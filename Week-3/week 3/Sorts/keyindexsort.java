import java.util.*;
class keyindexsort
{
	String key[];
	int value[];
	int count[];
	int cumcount[];
	String aux[];
	keyindexsort(String key[],int value[])
	{
		this.key=key;
		this.value=value;
		count=new int[key.length];
		cumcount=new int[key.length]; 
		aux=new String[key.length];
	}
	public void sort()
	{
		for(int i=0;i<key.length;i++)
		{
			// System.out.println((value[i]+1)+"        fghjkl;");

			count[value[i]+1]++;
			 // System.out.println(Arrays.toString(count)+"dfghjk");
		}
		for(int k=1;k<count.length;k++)
		{
			cumcount[k]=cumcount[k-1]+count[k];
		}
		for(int i=0;i<key.length;i++)
		{
			aux[cumcount[value[i]]++]=key[i];
		}
		for(int i=0;i<key.length;i++)
		{
			key[i]=aux[i];
		}
		System.out.println(Arrays.toString(count));
		System.out.println(Arrays.toString(cumcount));
		System.out.println(Arrays.toString(key));
	}
	public static void main(String[] args) {
		String str[]={"surya","surabhi","swathi","sneha","snehith"};
		// Arrays.sort(str);*
		

		int val[]={3,3,2,1,0};
		// System.out.println(Arrays.toString(str));
		// System.out.println(Arrays.toString(val));
		keyindexsort k=new keyindexsort(str,val);
		k.sort();
	}

}