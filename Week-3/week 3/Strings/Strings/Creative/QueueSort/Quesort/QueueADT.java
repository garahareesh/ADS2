import java.util.*;
class QueueADT{
	ArrayList<String> list;
	int n;
	QueueADT()
	{
		list=new ArrayList();
		n=0;
	}
	public void enqueue(String a)
	{
		list.add(a);
		n++;
	}
	public String get(int i)
	{
		return list.get(i);
	}
	public String dequeue()
	{
		String temp=list.remove(0);
		n--;
		return temp;
	}
	public int size()
	{
		return n;
	}
}