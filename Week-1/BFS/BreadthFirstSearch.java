//implement Breadth first search
import java.util.*;
public class BreadthFirstSearch
{
	private  boolean[] marked;
	private int [] edgeTo;
	public int source;
	// public int size;
	BreadthFirstSearch(Graph G,int source)
	{
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		for(int i=0;i<edgeTo.length;i++)
		{
			edgeTo[i]=i;
		}
		this.source=source;
		// this.size=0;
		bfs(G,source);
	}
	public void bfs(Graph G,int s)
	{
		Queue<Integer> q=new LinkedList<Integer>();
		marked[s]=true;		
		q.add(s);
		while(!q.isEmpty())
		{
			int temp=q.remove();
			for(int i: G.adjacent(temp))
			{
				if(!marked[i])
				{
					marked[i]=true;
					edgeTo[i]=temp;
					q.add(i);
				}
			}
		}
	}
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v)) return null;
		Stack<Integer> path=new Stack<>();
		for(int i=v;i!=source;i=edgeTo[i])
		{
			path.push(i);
		}
		path.push(source);
		return path;
	}
	public static void main(String[] args) {
		Graph graph = new Graph(12);
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
		BreadthFirstSearch breadth = new BreadthFirstSearch(graph,0);
		BreadthFirstSearch breadth1 = new BreadthFirstSearch(graph,7);
		System.out.println(graph.display());
		System.out.println(breadth.pathTo(10));
		System.out.println(breadth1.pathTo(1));
	}
}