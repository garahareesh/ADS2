import java.util.*;
public class QueueADT<T>{
	private int n=0;
	ArrayList q=new ArrayList();

	public void enqueue(T element){
		q.add(element);
		n++;
	}

	public T dequeue(){
		T no=(T)q.get(0);
		q.remove(0);
		return no;
	}

	public T get(int i){
		T no=(T)q.get(i);
		return no;
	}

	public int size(){
		return n;
	}

}