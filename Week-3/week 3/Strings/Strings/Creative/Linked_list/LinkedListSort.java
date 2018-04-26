import java.util.*;
//import java.lang.*;
class LinkedListSort{
	LinkedList<String> list=new LinkedList<String>();
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
	public static int charAt(String s,int d)
	{
		if(d<s.length()) return s.charAt(d);
		return -1;
	}
	public static void sort(LinkedList list,int lo, int hi,int d)
	{
		if(hi<=lo) return;
		int lt=lo;
		int gt=hi;
		int i=lo+1;
		int v=charAt((String)list.get(lo),d);
		while(i<=gt)
		{
			int t=charAt((String)list.get(i),d);
			if(t<v) exch(list,lt++,i++);
			else if(t>v) exch(list,i,gt--);
			else i++;
		}
		sort(list,i,lt-1,d);
		if(v>=0) sort(list,lt,gt,d+1);
		sort(list,gt+1,hi,d);
	}
	public static void exch(ArrayList list,int i,int j)
	{
		String temp=(String)list.get(i);
		list.set(i,(String)list.get(j));
		list.set(j,temp);
	}
	public static void main(String[] args) {
		String[] a={"she","sells","zxx","sea","shells","on","sea","shore","aa","a"};
		sort(a);
	}
}