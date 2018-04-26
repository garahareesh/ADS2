import java.util.*;
class huffman
{
	private static final int R=256;
	String st[];
	public huffman()
	{

	}
	public class Node implements Comparable<Node>
	{
		char ch;
		int freq;
		Node left,right;
		Node(char ch,int freq,Node left,Node right)
		{
			this.ch=ch;
			this.freq=freq;
			this.left=left;
			this.right=right;
		}
		public boolean isLeaf()
		{
			return (left==null)&(right==null);
		}
		public int compareTo(Node that)
		{
			return this.freq-that.freq;
		}
		public String toString()
		{
			return ch+" "+freq+" "+left+" "+right;
		}
	}
	public Node buildtrie(int []freq)
	{
		PriorityQueue<Node> pq=new PriorityQueue();
		for(char i=0;i<R;i++)
		{
			if(freq[i]>0)
				pq.add(new Node(i,freq[i],null,null));
		}
		if(pq.size()==1)
		{
			if(freq['\0']==0)
				pq.add(new Node('\0',0,null,null));
			else
				pq.add(new Node('\1',0,null,null));
		}
		while(pq.size()>1)
		{
			Node left=pq.poll();
			Node right=pq.poll();
			Node parent=new Node('\0',left.freq+right.freq,left,right);
			pq.add(parent);
		}
		return pq.poll();
	}
	public void buildcode(String []st,Node x,String s)
	{
		if(!x.isLeaf())
		{
			buildcode(st,x.left,s+'0');
			buildcode(st,x.right,s+'1');
		}
		else
		{
			st[x.ch]=s;
		}
	} 
	public void compress()
	{
		String s="ABRACADABRA";
		char []array=s.toCharArray();
		int freq[]=new int[R];
		for(int i=0;i<array.length;i++)
		{
			freq[array[i]]++;
		}
		Node root=buildtrie(freq);
		st=new String[R];
		buildcode(st,root,"");
		String result="";
		for(int i=0;i<array.length;i++)
		{
			result+=st[array[i]];
		}
		System.out.println(result);
	}
	public static void main(String[] args)
	{
		huffman h=new huffman();
		h.compress();
	}
}