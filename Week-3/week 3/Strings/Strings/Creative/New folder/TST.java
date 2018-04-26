import java.util.*;
class Node<T>{
	public char c;
	public Node<T> left,mid,right;
	public T val;
}
public class TST<T>{
	public int n;
	public Node<T> root;
	public TST(){}
	public int size(){
		return n;
	}
	public boolean contains(String key){
		return get(key)!=null;
	}
	public T get(String key){
		Node<T> x=get(root,key,0);
		if(x==null){
			return null;
		}
		return x.val;
	}
	public Node<T> get(Node<T> x,String key,int d){
		if(x==null){
			return null;
		}
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
	public void put(String key,T val){
		if(!contains(key)){
			n++;
		}
		root=put(root,key,val,0);
	}
	public Node<T> put(Node<T> x,String key,T val,int d){
		char c=key.charAt(d);
		if(x==null){
			x=new Node<T>();
			x.c=c;
		}
		if(c<x.c){
			x.left=put(x.left,key,val,d);
		}
		else if(c>x.c){
			x.right=put(x.right,key,val,d);
		}
		else if(d<key.length()-1){
			x.mid=put(x.mid,key,val,d+1);
		}
		else{
			x.val=val;
		}
		return x;
	}
	public Iterable<String> keys(){
		Queue<String> queue=new LinkedList<String>();
		String prefix="";
		collect(root,prefix,queue);
		return queue;
	}
	public Iterable<String> keysWithPrefix(String prefix){
		Queue<String> queue=new LinkedList<String>();
		Node<T> x=get(root,prefix,0);
		if(x==null){
			return queue;
		}
		if(x.val!=null){
			queue.add(prefix);
		}
		collect(x.mid,prefix,queue);
		return queue;
	}
	public void collect(Node<T> x,String prefix,Queue<String> queue){
		if(x==null){
			return;
		}
		collect(x.left,prefix,queue);
		if(x.val!=null){
			queue.add(prefix+x.c);
		}
		collect(x.mid,prefix+x.c,queue);
		collect(x.right,prefix,queue);
	}
	public String longestPrefixOf(String query){
		if(query.length()==0){
			return null;
		}
		int length=0;
		Node<T> x=root;
		int i=0;
		while(x!=null && i<query.length()){
			char c=query.charAt(i);
			if(c<x.c){
				x=x.left;
			}
			else if(c>x.c){
				x=x.right;
			}
			else{
				i++;
				if(x.val!=null){
					length=i;
				}
				x=x.mid;
			}
		}
		return query.substring(0,length);
	}
	public static void main(String[] args) {
		TST<Integer> tst=new TST<Integer>();
		tst.put("she",0);
		tst.put("sells",1);
		tst.put("shells",3);
		tst.put("by",4);
		tst.put("the",5);
		tst.put("sea",6);
		tst.put("shore",7);
		for(String s:tst.keys()){
			System.out.println(s+" "+tst.get(s));
		}
		System.out.println();
		System.out.println(tst.longestPrefixOf("shellsort"));
		System.out.println();
		for(String s:tst.keysWithPrefix("se")){
			System.out.println(s);
		}
	}
}