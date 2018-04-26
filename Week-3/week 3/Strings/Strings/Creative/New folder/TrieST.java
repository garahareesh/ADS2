import java.util.*;
class Node{
	public Object val;
	public Node[] next=new Node[256];
	public String toString(){
		String pj="";
		for(int i=0;i<256;i++){
			if(next[i]!=null)
			pj+=next[i].val+"";
		}
		return pj;
	}
}
public class TrieST<T>{
	public Node root;
	public int n;
	public TrieST(){

	}
	public void put(String key,T val){
		if(val==null){
			delete(key);
		}
		else{
			root=put(root,key,val,0);
		}


	}
	public Node put(Node x,String key,T val,int d){
		if(x==null){
			x=new Node();
		}
		if(d==key.length()){
			if(x.val==null){
				n++;
			}
			x.val=val;
			return x;
		}
		char c=key.charAt(d);
		x.next[c]=put(x.next[c],key,val,d+1);
		return x;
	}
	public T get(String key){
		Node x=get(root,key,0);
		if(x==null){
			return null;
		}
		return (T)x.val;
	}
	public Node get(Node x,String key,int d){
		if(x==null)
			return null;
		if(d==key.length()){
			return x;
		}
		char c=key.charAt(d);
		return get(x.next[c],key,d+1);
	}
	public Iterable<String> keys(){
		return keysWithPrefix("");
	}
	public Iterable<String> keysWithPrefix(String prefix){
		Queue<String> results=new LinkedList<String>();
		Node x=get(root,prefix,0);
		collect(x,prefix,results);
		return results;
	}
	public void collect(Node x,String prefix,Queue<String> results){
		if(x==null){
			return;
		}
		if(x.val!=null){
			results.add(prefix);
		}
		for(char c=0;c<256;c++){
			collect(x.next[c],prefix+c,results);
		}
	}
	public void delete(String key){
		root=delete(root,key,0);
	}
	public Node delete(Node x,String key,int d){
		if(x==null){
			return null;
		}
		if(d==key.length()){
			if(x.val!=null){
				n--;
			}
			x.val=null;
		}
		else{
			char c=key.charAt(d);
			x.next[c]=delete(x.next[c],key,d+1);
		}
		if(x.val!=null){
			return x;
		}
		for(int c=0;c<256;c++){
			if(x.next[c]!=null){
				return x;
			}
		}
		return null;
	}
	public String longestPrefixOf(String query){
		int length=longestPrefixOf(root,query,0,-1);
		if(length==-1){
			return null;
		}
		else{
			return query.substring(0,length);
		}
	}
	public int longestPrefixOf(Node x,String query,int d,int length){
		if(x==null){
			return length;
		}
		if(x.val!=null){
			length=d;
		}
		if(d==query.length()){
			return length;
		}
		char c=query.charAt(d);
		return longestPrefixOf(x.next[c],query,d+1,length);
	}

	public static void main(String[] args) {
		TrieST<Integer> pj=new TrieST<Integer>();
		
		pj.put("nandy",98);
		pj.put("pratik",35);
		pj.put("vamshi",25);
		pj.put("naresh",01);
		pj.put("gayath",31);
		pj.put("harish",05);
		
		
		for(String s:pj.keys()){
			System.out.println(s+" >>"+pj.get(s));
		}
		System.out.println();
		// pj.delete("gayath");
		// for(String s:pj.keysWithPrefix("na")){
		// 	System.out.println(s+" "+pj.get(s));
		// }
		System.out.println(pj.longestPrefixOf("pratikjoshiilakathamafiliya"));

		// pj.print("pratik");
		// System.out.println(pj);
	}

}