import java.util.*;
class AplphaLsd{
	public static void sort(String[] a,int w)
	{
		int n=a.length;
		String[] temp=new String[n];
		for(int d=w-1;d>=0;d--)
		{
			int[] count=new int[53];
			for(int i=0;i<n;i++)
			{
				if(97<=a[i].charAt(d)&&a[i].charAt(d)>=122)
					count[(a[i].charAt(d)-97+26)+1]++;
				else
					count[(a[i].charAt(d)-65)+1]++;
			}
			for(int r=0;r<52;r++)
				count[r+1]+=count[r];
			for(int i=0;i<n;i++)
			{
				if(97<=a[i].charAt(d)&&a[i].charAt(d)>=122)
					temp[count[a[i].charAt(d)-97+26]++]=a[i];
				else
					temp[count[a[i].charAt(d)-65]++]=a[i];
			}
			a=Arrays.copyOf(temp,n);
		}
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		// String[] a={"bed ","bug ","dad ","yes" ,"zoo","now ","for" ,"tip ","ilk ","dim","tag ","jot ","sob ","nob ","sky","hut ","men ","egg ","few ","jay","owl ","joy" ,"rap ","gig ","wee","was ","wad ","fee ","tap ","tar","dug ","jam ","all" ,"bad ","yet"};
		// String[] a={"zoo","yes","rey","hAi","sup","ass"};
		String[] a={"And","aNd","anD","AND","and"};
		sort(a,3);
	}
}