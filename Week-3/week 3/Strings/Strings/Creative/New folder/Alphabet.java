import java.util.*;
public class Alphabet{
	public void sort(String[] a,int w){
		int n=a.length;
		// int r=256;
		String[] aux=new String[n];
		for(int d=w-1;d>=0;d--){
			int[] count=new int[53];
			for(int i=0;i<n;i++){
				// System.out.println(a[i]);
				if(97<=a[i].charAt(d) && a[i].charAt(d)<=122)
				  		count[(a[i].charAt(d)+1)-97+26]++;
				else{
					// System.out.println(".............");
						count[(a[i].charAt(d)+1)-65]++;
					}
				}

			
			// System.out.println(Arrays.toString(count));
			for(int p=0;p<52;p++){
				count[p+1]+=count[p];
			} 
			for(int i=0;i<n;i++){
				if(97<=a[i].charAt(d) && a[i].charAt(d)<=122)
				  aux[count[(a[i].charAt(d)-97+26)]++]=a[i];
				else{
					// System.out.println(",,,,,,,,,,,,,,");
					aux[count[(a[i].charAt(d)-65)]++]=a[i];
				}
				}

			
			for(int i=0;i<n;i++){
				a[i]=aux[i];
			}
		}

	}
	public static void main(String[] args) {
		Alphabet lsd=new Alphabet();
		// String[] a={"bed ","bug ","dad ","yes" ,"zoo","now ","for" ,"tip ","ilk ","dim","tag ","jot ","sob ","nob ","sky","hut ","men ","egg ","few ","jay","owl ","joy" ,"rap ","gig ","wee","was ","wad ","fee ","tap ","tar","dug ","jam ","all" ,"bad ","yet"};
		// String[] a={"zoo","yes","rey","hAi","sup","ass"};
		String[] a={"And","aNd","anD","AND","and"};
		lsd.sort(a,3);
		System.out.println(Arrays.toString(a));
	}
}