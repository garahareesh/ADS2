import java.util.*;
class DirectedGraph
{
	private final int vertices;
	int edges;
	ArrayList<Integer> [] arr;
	public DirectedGraph(int v)
	{
		this.vertices=v;
		this.edges=0;
		arr=(ArrayList<Integer>[])new ArrayList[v];
		for(int i=0;i<vertices;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
	}
	public void addEdge(int v,int w)
	{
		arr[v].add(0,w);
		edges++;
	}
	public int V()
	{
		return vertices;
	}
	public Iterable<Integer> adj(int v)
	{
		return arr[v];
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<vertices;i++)
		{
			int count=0;
			s+=i+":";
			for(int w:arr[i])
			{
				if(count<arr[i].size()-1)
					s+=w+",";
				else
					s+=w;
				count++;
			}
			s+="\n";
		}
		return s;
	}
}

public class Solution {
	boolean marked[];
	boolean onStack[];
	int edgeTo[];
	// int source;
	Stack<Integer> cycle;
	public Solution(DirectedGraph G)
	{
		// this.source=source;
		marked=new boolean[G.V()];
		onStack=new boolean[G.V()];
		edgeTo=new int[G.V()];
		for(int i=0;i<edgeTo.length;i++){
			if(!marked[i])
				dfs(G,i);
		}
	}
	public void dfs(DirectedGraph G,int v)
	{
		onStack[v]=true;
		marked[v]=true;
		for(int w: G.adj(v))
		{
			if(cycle!=null) return ;
			else if(!marked[w])
			{
				edgeTo[w]=v;
				dfs(G,w);
			}
			else if(onStack[w])
			{
				cycle=new Stack<Integer>();
				for(int i=v;i!=w;i=edgeTo[i])
				{
					cycle.push(i);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v]=false;
	}
	public void hasCycle()
	{
		if(cycle!=null)
			System.out.println("yes");
		else
			System.out.println("no");
	}

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
        int noOfVertices=Integer.parseInt(sc.nextLine());
        int noOfEdges=Integer.parseInt(sc.nextLine());
        DirectedGraph g=new DirectedGraph(noOfVertices);
        for(int i=0;i<noOfEdges;i++)
        {
        	String str=sc.nextLine();
        	String[] ss=str.split(" ");
        	g.addEdge(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]));
        }
        System.out.print(g.toString());
        Solution ob=new Solution(g);
        ob.hasCycle();
        
    }
}