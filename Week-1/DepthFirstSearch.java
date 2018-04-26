//implement Dfs
import java.util.*;
public class DepthFirstSearch
{
	private boolean [] marked;
	private int[] edgeTo;
	public int size;
	private final int source;
	public DepthFirstSearch(Graph G, int source)
	{
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.size=0;
		this.source=source;
	}
	public void dfs(Graph G, int s)
	{
		marked[s]=true;
		size++;
		for(int i:G.adjacent(s))
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

}