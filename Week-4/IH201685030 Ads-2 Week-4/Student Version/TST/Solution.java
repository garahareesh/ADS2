public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOftestcase=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noOftestcase;i++)
		{
			Solution ob=new Solution();
			String str=sc.nextLine();
			String [] ss=str.split(" ");
			int n=ss.length;
			for(int j=0;j<n;i++)
				ob.put(ss[j]);
			String s1=sc.nextLine();
			ob.keys_with_prefix(s1);
			String s2=sc.nextLine();
			ob.longest_prefix_of(s2);
			String s3=sc.nextLine();
			ob.keys_that_match(s3);

		}	
	}	
}