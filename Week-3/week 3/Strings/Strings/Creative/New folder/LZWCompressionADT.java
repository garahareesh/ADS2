import java.util.*;
public class LZWCompressionADT{
	public Node root;
	String tempString="";
	int z=257;
	static String mstring;
	ArrayList al=new ArrayList();
	private static class Node{
		Node left,right,mid;
		char c;
		String s;
		Integer ascii;
		Integer val;

		Node(char c){
			left=null;
			right=null;
			mid=null;
			this.c=c;
			s=c+"";
		}

	}

	public LZWCompressionADT(){
		for(int i=97;i<123;i++){
			String temp=(char)i+"";
			put(temp,i,i);
		}

	}

	public void put(String key,int asc,int val){
		root=put(root,key,asc,val,0);
	}

	public Node put(Node x,String key,Integer asc,Integer val,int d){
		char c=key.charAt(d);
		if(x==null){
			// System.out.println(c);
			x=new Node(c);
			if(d<key.length()-1){
				x.mid=put(x.mid,key,asc,val,d+1);
			}
			else{
				x=new Node(c);
				x.ascii=asc;
				x.val=val;
			

			}
		return x;
		}

		else if(c>x.c){
			x.right=put(x.right,key,asc,val,d);
		}

		else if(c<x.c){
			x.left=put(x.left,key,asc,val,d);
		}

		else if(d<key.length()-1){
			x.mid=put(x.mid,key,asc,val,d+1);

		}
		else{
			x=new Node(c);
			x.ascii=asc;
			x.val=val;
			

		}
		return x;

		

	}
	public Integer get(String key){
		Node temp=get(root,key,0);
		if(temp==null){
			return null;
		}
		else{
			return temp.ascii;
		}
	}

	public Node  get(Node x,String key,int d){
		char c=key.charAt(d);
		if(c<x.c){
			return get(x.left,key,d);
		}
		else if(c>x.c){
			return get(x.right,key,d);
		}
		else if(d<key.length()-1){
			return get(x.mid,key,d+1);
		}
		else{
			return x;
		}
	}

	public String longestPrefix(String pre){
		System.out.println("Pre " + pre);
		tempString = "";
		return longestPrefix(root,pre,0);
	}

	public String longestPrefix(Node x,String pre,int d){
		if (d == pre.length()) {
			return tempString;
		}
		char c=pre.charAt(d);
		// if(c<x.c){
		// 	longestPrefix(x.left,pre,d);
		// }
		// else if(c>x.c){
		// 	longestPrefix(x.right,pre,d);
		// }
		// else if(c==x.c){
		// 	tempString=tempString+c;
		// 	if(d<pre.length()-1){
		// 		longestPrefix(x.mid,pre,d+1);	
		// 	}
			
		// }
		if(x==null){
			return tempString;
		}

		if(c<x.c){
			return longestPrefix(x.left,pre,d);
		}
		else if(c>x.c){
			return longestPrefix(x.right,pre,d);
		}
		else{
			tempString=tempString+c;
			if(d<pre.length()-1){
				return longestPrefix(x.mid,pre,d+1);
			}
		}

		return tempString;
	}

	public void encode(String input){
		// int z=257;
		// int i=0;
		// String temp="";
		// String s=str;
		// while(s.length()!=temp.length()){
		// 	// System.out.println("hello");
			
		// 	System.out.println("s "+s);
		// 	System.out.println(al);
		// 	temp=longestPrefix(s);
		// 	System.out.println("temp in encode : "+temp);
		// 	// System.out.println("temp"+temp);
		// 	String putString=s.substring(0,temp.length());
		// 	System.out.println("p-> "+putString);
		// 	s=s.substring(temp.length(),s.length());
		// 	al.add(get(temp));
		// 	put(putString,z,z);
		// 	z++;
		// 	i=1;

		// }
		// System.out.println(al);
		if (input == "") {
			System.out.println(al);
			return;
		}
		String lpre = longestPrefix(input);
		al.add(get(lpre));
		String mstring= input.substring(lpre.length(),input.length());
		String putString = lpre;
		if (mstring.length() > 0) {
			putString += mstring.charAt(0);

			put(putString,z,z);
			z++;
		} else {
			System.out.println(al);
			return;}
		// System.out.println("get value : "+get(lpre));
		// al.add(get(lpre));
		System.out.println("longest longestPrefix : "+lpre);
		System.out.println("mstring "+mstring);
		encode(mstring);
	}

	public void expand(ArrayList al){
		String []st=new String[4096];
		int i;
		for(i=0;i<256;i++){
			st[i]=""+(char)i;
		}
		st[i++]=" ";
		int codeword=(int)al.get(0);
		String val=st[codeword];
		String ans=val;
		int x=1;

		while(x<al.size()){
			// System.out.println(val);
			codeword=(int)al.get(x);
			// if(codeword==256){
			// 	break;
			// }
			String s=st[codeword];
			if(i==codeword){
				s=val+val.charAt(0);
			}
			if(i<4096){
				st[i++]=val+s.charAt(0);
			}
			val=s;
			ans+=val;
			x++;
		}

		System.out.println(ans);
	}

	public static void main(String[] args) {
		LZWCompressionADT lca =new LZWCompressionADT();
		mstring="abracadabra";
		lca.encode(mstring);
		//lca.put("abrac",789,789);
		//lca.encode("abracadabra");
		// System.out.println(lca.get("z"));
		// lca.put("ab", 257, 257);
		// System.out.println(lca.longestPrefix("bracadabra"));
		// System.out.println(lca.root);
		// int foo = Integer.parseInt("1001", 2);
		// System.out.println(foo);
		lca.expand(lca.al);
	}

}