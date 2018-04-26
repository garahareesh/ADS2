import java.util.*;
public class LinkedListSort{
	public LinkedList<String> pj;
	public LinkedListSort(String[] a){
		pj=new LinkedList<String>();
		for(int i=0;i<a.length;i++){
			pj.add(a[i]);
		}
		sort(pj,0,pj.size()-1,0);
		System.out.println("hi"+(3<<5));
		System.out.println(pj);
	}
	public int charAt(String s,int d){
		// if(s.length()==d){
		// 	return -1;
		// }
		// return s.charAt(d);
		if(d<s.length()){
			return s.charAt(d);
		}
		else{
			return -1;
		}
	}

	public void sort(LinkedList pj,int lo,int hi,int d){
		if(hi<=lo){
			return;
		}
		int lt=lo;
		int gt=hi;
		int i=lo+1;
		int v=charAt((String)pj.get(lo),d);
		while(i<=gt){
			int t=charAt((String)pj.get(i),d);
			if(t<v){
				exch(pj,lt++,i++);
			}
			else if(t>v){
				exch(pj,i,gt--);
			}
			else{
				i++;
			}
		}
		sort(pj,lo,lt-1,d);
		if(v>=0){
			sort(pj,lt,gt,d+1);

		}
		sort(pj,gt+1,hi,i);
	}
	public void exch(LinkedList pj,int a,int b){
		Object temp=pj.get(a);
		pj.set(a,pj.get(b));
		pj.set(b,temp);
	}
	public static void main(String[] args) {
		String[] a={"she","sells","sea","shells","on","sea","shore"};
		LinkedListSort ls=new LinkedListSort(a);
	}
}