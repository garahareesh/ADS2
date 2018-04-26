//implement Dfs 
import java.util.*;
public class DepthFirstSearch
{
	private boolean [] marked;
	private int[] edgeTo;
	public int size;
	private final int source;
	public DepthFirstSearch(EdgeWeightedGraph G, int source)
	{
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.size=0;
		this.source=source;
	}
	public void dfs(Graph G, int s)
	{
		// System.out.println("injbvjbvkbv"+ s);
		// System.out.println(Arrays.toString(marked));
		marked[s]=true;
		// System.out.println(Arrays.toString(marked));
		size++;
		for(int i: G.adjacent(s))
		{
			if(!marked[i])
			{
				edgeTo[i]=s;
				dfs(G,i);
			}
		}
	}
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	public boolean isConnected()
	{
		for(int i=0;i<G.V();i++)
		{
			if(marked[i]==false)
				return false;
		}
		return true;
	}
	public Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v)) return null;
		Stack<Integer> stack=new Stack<>();
		for(int i=v;i!=source;i=edgeTo[i])
		{
			stack.push(i);
		}
		stack.push(source);
		return stack;
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

		DepthFirstSearch d = new DepthFirstSearch(graph,7);
		d.dfs(graph,7);
		System.out.println(d.pathTo(4));
		System.out.println(d.pathTo(6));
		// Scanner sc=new Scanner()

		
	}
}


