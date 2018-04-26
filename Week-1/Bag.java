//implement Bag
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
		return (current!=null);
	}
	public Item next()
	{
		if(!hasNext()) throw new NoSuchElementException();
		Item temp=current.item;
		current=current.next;
		return temp;
	}
}
public class Bag<Item> implements Iterable<Item>
{
	Node<Item> head;
	int num;
	Bag()
	{
		this.head=null;
		this.num=0;
	}
	boolean isEmpty()
	{
		return head==null;
	}
	int size()
	{
		return num;
	}
	void add(Item item)
	{
		Node<Item> temp=head;
		head=new Node<Item>();
		head.item=item;
		head.next=temp;
		num++;
	}
	public Iterator<Item> iterator()
	{
		return new ListIterator<Item>(head);
	}
	
}