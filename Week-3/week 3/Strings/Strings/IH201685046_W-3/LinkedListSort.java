import java.util.*;
class LinkedListSort{
	LinkedList<String> list;
	LinkedListSort()
	{

	}
	public void sort(String[] a)
	{
		int n=a.length;
		list=new LinkedList();
		for(String e:a) list.add(e);
		sort(list,0,n-1,0);
	System.out.println(list);
	}
	public int charAt(String s, int d)
	{
		if(d>=s.length()) return -1;
		return s.charAt(d);
	}
	public void sort(LinkedList list,int lo, int hi, int d)
	{
		if(hi<=lo) return;
		int lt=lo;
		int gt=hi;
		int i=lo+1;
		int v=charAt((String)list.get(lo),d);
		while(i<=gt)
		{
			int t=charAt((String)list.get(i),d);
			if(t<v)exch(list,i++,lt++);
			else if(t>v)exch(list,i,gt--);
			else i++;
		}
		sort(list,lo,lt-1,d);
		if(v>=0)sort(list,lt,gt,d+1);
		sort(list,gt+1,hi,d);
	}
	public void exch(LinkedList list,int i, int j)
	{
		Object temp=list.get(i);
		list.set(i,list.get(j));
		list.set(j,temp);
	}
	public static void main(String[] args) {
		String a="Give a trace for 3-way string quicksort for the keys";
		String b="no is th ti fo al go pe to co to th ai of th pa";
		//String[] s={"no","is","th","ti","fo","al","go","pe","to","co","to","th","ai","of","th","pa"};
		String[] s=a.split(" ");
		LinkedListSort one=new LinkedListSort();
		one.sort(s);
	}
}