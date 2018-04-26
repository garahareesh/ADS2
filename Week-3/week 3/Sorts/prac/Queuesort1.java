import java.util.*;
class Queue<T>
{
	int i;
	ArrayList al=new ArrayList<>();
	public void enqueue(T ele)
	{
		al.add(ele);
		i++;
	}
	public T dequeue(){
		T g=(T)al.get(0);
		al.remove(0);
		return g;

	}
	public T get(int i)
	{
		T g=(T)al.get(i);
		return g;
	}
	public int size()
	{
		return i;
	}
	
}
class QueueSort1
{
	int R=256;
	public int charAt(String s,int d)
	{
		if(d>=s.length())
		{
			return -1;
		}
		return (int)s.charAt(d);
	}
	public String sort(String s)
	{
		Queue q=new Queue();
		String[] input=s.split(" ");
		String result="";
		for(String st:input)
		{
			q.enqueue(st);
		}
		q=sort(q,0);
		for(int i=0;i<q.size();i++)
		{
			result+=(String)q.get(i)+" ";
		}
		return result.trim();

	}
	public Queue sort(Queue input,int d)
	{
		Queue[] array=new Queue[R];
		Queue aux=new Queue();
		if(input.size()==1)
		{
			return input;
		}
		for(int i=0;i<input.size();i++)
		{
			String temp=(String)input.get(i);
			if(charAt(temp,d)==-1)
			{
				aux.enqueue(temp);
				continue;
			}
			if(array[charAt(temp,d)]==null)
			{
				array[charAt(temp,d)]=new Queue();
			}
			array[charAt(temp,d)].enqueue(temp);
		}
		for(int i=0;i<R;i++)
		{
			if(array[i]!=null)
			{
				array[i]=sort(array[i],d+1);
			}
		}
		for(int i=0;i<R;i++)
		{
			if(array[i]!=null)
			{
				 Queue temp=array[i];
				for(int j=0;j<temp.size();j++)
				{
					aux.enqueue(temp.get(j));

				}
			}
		}
		return aux;
	}
	public static void main(String[] args) {
		QueueSort1 qsort = new QueueSort1();
		
		String re = qsort.sort("she sells seashells by the sea shore the shells she sells are surely seashells");
		System.out.println(re);
	}
}