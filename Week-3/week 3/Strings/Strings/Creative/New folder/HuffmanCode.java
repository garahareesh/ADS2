import java.util.*;
public class HuffmanCode{
	// Node []real;
	MinPQ<Node> mpq;
	String realStr;
	String ans="";
	String decom="";
	public HuffmanCode(String s){
		// real=new real[256];
		realStr=s;
		mpq=new MinPQ<Node>();
		ArrayList<String> al = new ArrayList<String>();
		for(int i=0;i<s.length();i++){
			if(!al.contains(s.charAt(i) + "") && s.charAt(i)!=' '){
				al.add(s.charAt(i) + "");
			}
		}
		for(int j=0;j<al.size();j++){
			int count=0;
			// System.out.print(al.get(j));
			for(int k=0;k<s.length();k++){
				if(al.get(j).equals(s.charAt(k) + "")){
					count++;
				}
			}
			Node nd=new Node(count);
			nd.str = al.get(j);
			mpq.insert(nd);
		}
	

	}

	public void encode(){
		// Iterator<Node> it=mpq.iterator();
		// while(it.hasNext()){
		// 	System.out.println(it.next().freq);
		// }
		while(mpq.size()!=1){
			encode(4);
		}
		System.out.println();
		Node node=mpq.delMin();
		mpq.insert(node);
		System.out.println(node.str);
	}

	public void encode(int p){
		Node node1= mpq.delMin();
		System.out.print(node1 + " ");
		Node node2=mpq.delMin();
		System.out.print(node2 + " ");
		if(node1.compareTo(node2) > 0){
			String s="";
			s = s + node1.str + node2.str;
			System.out.println(s);
			Node temp=new Node(node1.freq+node2.freq);
			temp.left=node2;
			temp.right=node1;
			temp.str=s;
			mpq.insert(temp);
		} else {
			String s="";
			s=s+node1.str+node2.str;
			System.out.println(s);
			Node temp=new Node(node1.freq + node2.freq);
			temp.str=s;
			temp.left=node1;
			temp.right=node2;
			mpq.insert(temp);
		}

	}

	public void decode(){
		for(int x=0;x<realStr.length();x++){
			char c=realStr.charAt(x);
			if(c!=' '){
				Node temp=mpq.delMin();
			// for(int i=0;i<temp.str.length();i++){
			// 	if(temp.str.charAt(i)==c){
			// 		for()
			// 	}
			// }
			System.out.println("chekc");
			mpq.insert(temp);
			decode(c,temp);
			
			ans=ans+" ";
			}
			

		}
		System.out.println(ans);
	}

	public void decode(char c,Node nd){
		// Node temp=mpq.delMin();
		// for(int i=0;i<temp.str.length();i++){
		// 	if()
		// }
		// System.out.println("node check "+nd);
		int i=0;
		while(true){
			System.out.println("c-> "+c+",nd -> "+nd.str);
			System.out.println(check(c,nd));
			if(check(c,nd)){
				nd=nd.left;
				ans=ans+"0";
				if(nd==null){
					System.out.println("breaking");
					break;
				}
				if(nd.str.charAt(i)==c && nd.str.length()==1){
					break;
				}
				
				// i++;
			}
			else{
				nd=nd.right;
				ans=ans+"1";
				if(nd==null){
					System.out.println("breaking");
					break;
				}
				if(nd.str.charAt(i)==c && nd.str.length()==1){
					break;
				}
				

			}
		}
	}
	public boolean check(char c,Node n){
		Node n1=n.left;
		Node n2=n.right;
		for(int i=0;i<n1.str.length();i++)
		{
			if(n1.str.charAt(i)==c){
				return true;
			}
		}
		for(int j=0;j<n2.str.length();j++){
			if(n2.str.charAt(j)==c){
				return false;
			}
		}
		return false;
	}

	public void decompress(String ans,Node nde){
		Node temp=nde;
		for(int i=0;i<ans.length();i++){
			char c=ans.charAt(i);
			if(c!=' '){
				if(c=='0'){
					nde=nde.left;
					if(nde.str.length()==1){
						decom=decom+nde.str;
						nde=temp;
					}
				}
				else{
					nde=nde.right;
					if(nde.str.length()==1){
						decom=decom+nde.str;
						nde=temp;
					}
				}
			}
		}
		System.out.println(decom);
		
	}

	public static void main(String[] args) {
		String ss="sixstickyskeletons";
		HuffmanCode hmc=new HuffmanCode(ss);
		hmc.encode();
		hmc.decode();
		Node n1=hmc.mpq.delMin();
		hmc.mpq.insert(n1);
		hmc.decompress(hmc.ans,n1);

	}
}