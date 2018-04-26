import java.util.*;
class QueueSort{
	int R=256;
	public void sort(String s)
	{
		String[] a=s.split(" ");
		Queue<String> q=new LinkedList();
		for(String e:a) q.add(e);
		q=sort(q,0);
		System.out.println(q);
	}
	public int charAt(String s, int d)
	{
		if(d>=s.length()) return -1;
		return s.charAt(d);
	}
	public Queue sort(Queue q,int d)
	{
		if(q.size()<=1) return q;
		Queue[] arr=new LinkedList[R];
		Queue<String> aux=new LinkedList();	
		int n=q.size();
		for(int i=0;i<n;i++)
		{
			String temp=(String)q.peek();
			if(charAt(temp,d)==-1){
				aux.add((String)q.remove());
				continue;
			}
			if(arr[charAt(temp,d)]==null)
				arr[charAt(temp,d)]=new LinkedList();
			arr[charAt(temp,d)].add(q.remove());
		}
		for(int r=0;r<R;r++)
		{
			if(arr[r]!=null)
				arr[r]=sort(arr[r],d+1);
		}
		for(int r=0;r<R;r++)
		{
			if(arr[r]!=null){
				Queue temp_q=arr[r];
				int size=temp_q.size();
				for(int i=0;i<size;i++)
					aux.add((String)temp_q.remove());
			}
		}
		return aux;
	}
	public static void main(String[] args) {
		QueueSort qsort= new QueueSort();
		// String result=qsort.sort("she sells sea shells on sea shore");
		qsort.sort("hi jaffa ga aaaa zzz");
	}
}