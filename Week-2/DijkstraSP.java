import java.util.*;
class DirectedEdge implements Comparable<DirectedEdge>
{
	int v,w;
	double weight;
	DirectedEdge(int v,int w,double weight)
	{
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	public int from()
	{
		return v;
	}
	public int to()
	{
		return w;
	}
	public double weight()
	{
		return weight;
	}
	public int compareTo(DirectedEdge that)
	{
		return Double.compare(this.weight,that.weight);
	}
	public String toString()
	{
		return v+"->"+w+" "+String.format("%5.2f",weight);
	}
}
class DirectedWeightedDigraph
{
	private final int vertices;
	private int E;
	private ArrayList<DirectedEdge>[] bag;
	private int [] indegree;
	public DirectedWeightedDigraph(int v)
	{
		this.vertices=v;
		this.E=0;
		bag=(ArrayList<DirectedEdge>[])new ArrayList[vertices];
		for(int i=0;i<vertices;i++)
		{
			bag[i]=new ArrayList<DirectedEdge>();
		}
	}
	public int V()
	{
		return vertices;
	}
	public int E()
	{
		return E;
	}
	public void addEdge(DirectedEdge e)
	{
		int v=e.from();
		int w=e.to();
		bag[v].add(e);
		E++;
		indegree[w]++;
	}
	public int indegree(int v)
	{
		return indegree[v];
	}
	public int outdegree(int v)
	{
		return bag[v].size();
	}
	public Iterable<DirectedEdge> adj(int v)
	{
		return bag[v];
	}
	public Iterable<DirectedEdge> edges()
	{
		ArrayList<DirectedEdge> b=new ArrayList<DirectedEdge>();
		for(int v=0;v<vertices;v++)
		{
			for(DirectedEdge e:bag[v])
			{
				b.add(e);
			}
		}
		return b;
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<vertices;i++)
		{
			int count=0;
			s+=i+":";
			for(DirectedEdge j:bag[i])
			{
				if(count<bag[i].size())
					s+=j+",";
				else
					s+=j;
			}
			s+="\n";
		}
		return s;
	}
}
public class DijkstraSP
{
	private double[] distTo;
	private DirectedEdge[] edgeTo;
	private IndexMinPQ<Double>pq;
	DirectedWeightedDigraph g;
	DijkstraSP(DirectedWeightedDigraph g,int s)
	{
		this.g=g;
		pq=new IndexMinPQ<>(g.V());
		edgeTo=new DirectedEdge[g.V()];
		distTo=new double[g.V()];
		for(int i=0;i<g.V();i++)
		{
			distTo[i]=Double.POSITIVE_INFINITY;
		}
		distTo[s]=0.0;
		pq.add(s,0.0);
		while(!pq.isEmpty())
		{
			int e=pq.poll();
			relax (g,e);
		}
	}
	void relax(DirectedWeightedDigraph g,int s)
	{
		for(DirectedEdge e:g.adj(s))
		{
			int v=e.to();
			if(distTo[v]>distTo[s]+e.weight())
			{
				distTo[v]=distTo[s]+e.weight();
				edgeTo[v]=edgeTo[s];
				if(!pq.contains(v)) pq.add(v,distTo[v]);
				else pq.change(v,distTo[v]);
			}
		}
	}

}