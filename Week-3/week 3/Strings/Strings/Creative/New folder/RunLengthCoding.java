public class RunLengthCoding{
	public String encoding(String s){
		String temp="";
		int len=s.length();
		if(s.charAt(0)=='1'){
				temp=temp+0;
		}
		int j;
		for(int i=0;i<len;i=j){
			int count=0;
			for(j=i;j<len;j++){
				if(s.charAt(i)==s.charAt(j)){
					count++;
				}
				if(s.charAt(i)!=s.charAt(j)){
					break;
				}
			}

			temp=temp+" "+count;
			// System.out.println(temp);
			// count=0;

		}
		return temp;
	}

	public String decoding(String s){
		String temp="";

		for(int i=0;i<s.length();i++){
			// int n=Integer.parseInt(new String(s.charAt(i)));
			int n=Character.getNumericValue(s.charAt(i));System.out.println(n+"");
			if(i%2==0){
				for(int j=0;j<n;j++){
					temp=temp+0;
				}
			}
			else{
				for(int j=0;j<n;j++){
					temp=temp+1;
				}
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		RunLengthCoding rlc=new RunLengthCoding();
		System.out.println(rlc.encoding("111110000000"));
		System.out.println(rlc.decoding("057"));
	}
}