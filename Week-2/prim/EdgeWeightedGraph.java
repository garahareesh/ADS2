import java.util.*;
public class EdgeWeightedGraph
{
	private final int vertices;
	public int edges;
	ArrayList<Edge> []bag;
	public EdgeWeightedGraph(int v)
	{
		this.vertices=v;
		this.edges=0;
		bag=(ArrayList<Edge>[])new ArrayList[v];
		for(int i=0;i<vertices;i++)
		{
			bag[i]=new ArrayList<Edge>();
		}
	}
	public void addEdge(Edge e)
	{
		int v=e.either();
		int w=e.other(v);
		bag[v].add(0,e);
		bag[w].add(0,e);
		edges++;
	}
	public int V()
	{
		return vertices;
	}
	public Iterable<Edge> adj(int v)
	{
		return bag[v];
	}
	public int degree(int v)
	{
		return bag[v].size();
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<vertices;i++)
		{
			s+=i+":";
			for(Edge e:adj(i))
			{
				s+=e+" ";
			}
			s+="\n";
		}
		return s;
	}
}