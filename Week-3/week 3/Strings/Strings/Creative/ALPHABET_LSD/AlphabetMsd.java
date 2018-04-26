import java.util.*;
class AlphaMsd{
	public static void sort(String[] a)
	{
		int n=a.length;
		String[] temp=new String[n];
		sort(a,0,n-1,0,temp);
		System.out.println(Arrays.toString(a));
	}
	public static int charAt(String s, int d)
	{
		if(d>=s.length()) return -1;
		return s.charAt(d);
	}
	public static void sort(String[] a,int lo,int hi,int d,String[] temp)
	{
		if(hi<=lo)return;
		int R=52;
		int[] count=new int[R+2];
		for(int i=lo;i<=hi;i++)
		{
			int c=charAt(a[i],d);
			if(97<=c&&c>=122) count[(c-97+26)+2]++;
			else if(c==-1) count[c+2]++;
			else count[(c-65)+2]++;
		}
		for(int r=0;r<R+1;r++)
			count[r+1]+=count[r];
		for(int i=lo;i<=hi;i++)
		{
			int c=charAt(a[i],d);
			if(97<=c&&c>=122) temp[count[(c-97+26)+1]++]=a[i];
			else if(c==-1)temp[count[c+1]++]=a[i];
			else temp[count[(c-65)+1]++]=a[i];
		}
		for(int i=lo;i<=hi;i++)
			a[i]=temp[i-lo];
		for(int i=0;i<R;i++)
			sort(a,lo+count[i],lo+count[i+1]-1,d+1,temp);
		//System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		// String[] a={"bed ","bug ","dad ","yes" ,"zoo","now ","for" ,"tip ","ilk ","dim","tag ","jot ","sob ","nob ","sky","hut ","men ","egg ","few ","jay","owl ","joy" ,"rap ","gig ","wee","was ","wad ","fee ","tap ","tar","dug ","jam ","all" ,"bad ","yet"};
		// String[] a={"zoo","yes","rey","hAi","sup","ass"};
		// String[] a={"And","aNd","anD","AND","and"};
		String[] a={"aa","aaa","aaaa","AA","Abc","Bcdd","A","a","aNd","And","and","anD"};
		sort(a);
	}
}