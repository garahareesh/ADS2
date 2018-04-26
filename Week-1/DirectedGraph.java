import java.util.*;
class Node<Item>
{
	Item item;
	Node<Item>next;
}
class ListIterator<Item> implements Iterator<Item>
{
	Node<Item> current;
	ListIterator(Node<Item> first)
	{
		this.current=first;
	}
	public boolean hasNext()
	{
		return current!=null;
	}
	public Item next()
	{
		if(!hasNext()) throw new NoSuchElementException();
		Item temp=current.item;
		current=current.next;
		return temp;

	}
}
class Bag<Item> implements Iterable<Item>
{
	Node<Item> head;
	int size;
	Bag()
	{
		head=null;
		size=0;
	}
	public void add(Item item)
	{
		Node<Item>temp=head;
		head=new Node<Item>();
		head.item=item;
		head.next=temp;
		size++;
	}
	public Iterator<Item> iterator()
	{
		return new ListIterator<Item>(head);
	}
	public int size()
	{
		return size;
	}
}
public class DirectedGraph
{
	private int vertices;
	int edges;
	Bag<Integer>[] adj;
	int count;
	private int[] indegree;
	DirectedGraph(int v)
	{
		this.vertices=v;
		this.edges=0;
		count=0;
		indegree=new int[v];
		adj=(Bag<Integer>[])new Bag[v];
		for(int i=0;i<v;i++)
			adj[i]=new Bag<Integer>();

	}
	public void addEdge(int v,int w)
	{
		isValidate(v);
		isValidate(w);
		edges++;
		adj[v].add(w);
		indegree[w]++;
	}
	public void isValidate(int v)
	{
		if(v<0 || v>vertices) throw new NoSuchElementException();
	}
	public Iterable<Integer> adjacent(int v)
	{
		return adj[v];
	}
	public int V()
	{
		return vertices;
	}
	public int E()
	{
		return edges;
	}
	public int outDegree(int v)
	{
		return adj[v].size();
	}
	public int inDegree(int v)
	{
		return indegree[v];
	}
	public DirectedGraph reverse()
	{
		DirectedGraph reverse=new DirectedGraph(vertices);
		for(int i=0;i<vertices;i++)
		{
			for(int w:adj[i])
			{
				reverse.addEdge(w,i);
			}
		}
		return reverse;
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<vertices;i++)
		{
			int count=0;
			s+=i+":";
			for(int j:adj[i])
			{
				if(count<adj[i].size()-1)
					s+=j+",";
				else
					s+=j;
				count++;
			}
			s+="\n";
		}
		return s;
	}
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(12);
		graph.addEdge(8,4);
		graph.addEdge(2,3);
		graph.addEdge(1,11);
		graph.addEdge(0,6);
		graph.addEdge(3,6);
		graph.addEdge(10,3);
		graph.addEdge(7,11);
		graph.addEdge(7,8);
		graph.addEdge(11,8);
		graph.addEdge(2,0);
		graph.addEdge(6,2);
		graph.addEdge(5,2);
		graph.addEdge(5,10);
		graph.addEdge(3,10);
		graph.addEdge(8,1);
		graph.addEdge(4,1);
		System.out.println(graph.toString());
	}	
}