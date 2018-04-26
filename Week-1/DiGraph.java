//implement digraph
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
		Node<Item> temp=head;
		head=new Node<Item>();
		head.item=item;
		head.next=temp;
		size++;
	}
	public int size()
	{
		return size;
	}
	public Iterator<Item> iterator()
	{
		return new ListIterator<Item>(head);
	}
}
public class DiGraph
{
	int vertices;
	int edges;
	Bag<Integer>[] bag;
	DiGraph(int vertices)
	{
		this.vertices=vertices;
		this.edges=0;
		bag=(Bag<Integer>[]) new Bag[vertices];
		for(int i=0;i<vertices;i++)
		{
			bag[i]=new Bag<Integer>();
		}
	}
	public void addEdge(int v,int w)
	{
		isValidate(v);
		bag[v].add(w);
		edges++;
	}
	void isValidate(int a)
	{
		if(a<0 || a>=vertices) throw new NoSuchElementException();
	}
	int V()
	{
		return vertices;
	}
	int E()
	{
		return edges;
	}
	public Iterable<Integer> adjacent(int v)
	{
		return bag[v];
	}
	public int degree(int v)
	{
		return bag[v].size;
	}
	public boolean hasEdge(int v,int w)
	{
		System.out.println("has Edge:");
		for(int i:adjacent(v))
		{
			if(i==w)return true;
		}
		return false;
	}
	public void display()
	{
		String s="";
		for(int i=0;i<vertices;i++)
		{
			s=s+i+":";
			for(int j:bag[i])
			{
				s=s+j+" ";
			}
			s=s+"\n";
		}
		System.out.println(s);
	}
	public static void main(String[] args) {
		DiGraph graph = new DiGraph(12);
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
		graph.display();
		System.out.println(graph.hasEdge(8,4));
	}
}