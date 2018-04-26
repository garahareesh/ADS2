import java.util.*;
public class Prim
{
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean marked[];
	private PriorityQueue<Double> pq;
	public Prim(EdgeWeightedGraph G)
	{
		edgeTo=new Edge[G.V()];
		distTo=new double[G.V()];
		marked=new boolean[G.V()];
		pq=new PriorityQueue<Double>(G.V());
		for(int v=0;v<G.V();v++)
		{
			distTo[v]=Double.POSITIVE_INFINITY;
		}
		for(int i=0;i<G.V();i++)
		{
			if(!marked[i])
				prim(G,i);
		}
	}
	private void prim(EdgeWeightedGraph G,int s)
	{
		distTo[s]=0.0;
		pq.add(s,distTo[s]);
		while(!pq.isEmpty())
		{
			int v=pq.poll();
			scan(G,v);
		}
	}
	public void scan(EdgeWeightedGraph G,int s)
	{
		marked[s]=true;
		for(Edge e:G.adj(s))
		{
			int w=e.other(s);
			if(marked[w]) continue;
			if(e.weight()<distTo[w])
			{
				distTo[w]=e.weight();
				edgeTo[w]=e;
				if(pq.contains(w)) 
			}
		}
	}

}