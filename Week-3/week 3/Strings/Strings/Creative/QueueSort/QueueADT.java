import java.util.*;
class QueueADT<T>{
	ArrayList<T> q=new ArrayList<T>();
	int n=0;
	QueueADT()
	{
		
	}
	public void enqueue(T ele)
	{
		q.add(ele);
		n++;
	}
	public T dequeue()
	{
		T temp=(T)q.get(0);
		q.remove(0);
		n--;
		return temp;
	}
	public T get(int i)
	{
		return (T)q.get(i);
	}
	public int size()
	{
		return n;
	}	
}