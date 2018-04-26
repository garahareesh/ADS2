import java.util.*;
class Lexicographic
{
	
	public void Lexicographic(String s)
	{
		String t=s+s;
		String[] rotation=new String[s.length()];
		for(int i=0;i<s.length();i++)
		{
			rotation[i]=t.substring(i,i+s.length());
		}
		Arrays.sort(rotation);
		System.out.println(Arrays.toString(rotation));
		Arrays.sort(rotation);
      System.out.println("-------------------------------");
      System.out.println(Arrays.toString(rotation));
      System.out.println("Minimum:  "+rotation[0]);
      System.out.println("Maximum:  "+rotation[s.length()-1]);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a String:");
		String s=sc.nextLine();
		Lexicographic al=new Lexicographic();
		al.Lexicographic(s);
	}
	
}