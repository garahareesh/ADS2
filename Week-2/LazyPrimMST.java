import java.util.*;
public class LazyPrimMST
{
	private static final double FLOATING_POINT_EPSILON=1E-12;
	private double weight;
	private Queue<Edge> mst;
	private boolean [] marked;
	private PriorityQueue<Edge> pq;
	public LazyPrimMST(EdgeWeightedGraph G)
	{
		mst=new LinkedList<Edge>();
		pq=new PriorityQueue<Edge>();
		marked=new boolean[G.V()];
		for(int v=0;v<G.V();v++)
		{
			if(!marked[v])
				prim(G,v);
		}
	}	
	private void prim(EdgeWeightedGraph G, int s)
	{
		scan(G,s);
		while(!pq.isEmpty())
		{
			Edge e=pq.poll();
			int v=e.either();
			int w=e.other(v);
			if(marked[v] && marked[w])
				continue;
			mst.add(e);
			weight+=e.weight();
			if(!marked[v]) scan(G,v);
			if(!marked[w]) scan(G,w);
		}
	}
	private double weight()
	{
		return weight;
	}
	private void scan(EdgeWeightedGraph G,int v)
	{
		marked[v]=true;
		for(Edge e:G.adj(v))
			if(!marked[e.other(v)])
				pq.add(e);
	}
	public Iterable<Edge> edges()
	{
		return mst;
	}
	public static void main(String[] args) {
		Edge e1=new Edge(4,5,0.78);
		Edge e2=new Edge(3,2,0.25);
		Edge e3=new Edge(1,2,0.50);
		Edge e4=new Edge(6,5,0.29);
		Edge e5=new Edge(6,1,0.65);
		Edge e6=new Edge(2,5,0.15);
		Edge e7=new Edge(3,4,0.01);
		Edge e8=new Edge(1,4,0.05);
		Edge e9=new Edge(0,1,0.25);
		EdgeWeightedGraph e=new EdgeWeightedGraph(7);
		e.addEdge(e1);
		e.addEdge(e2);
		e.addEdge(e3);
		e.addEdge(e5);
		e.addEdge(e4);
		e.addEdge(e6);
		e.addEdge(e7);
		e.addEdge(e8);
		e.addEdge(e9);
		System.out.println(e);
		LazyPrimMST l=new LazyPrimMST(e);
		// System.out.println(l.pq);
		System.out.println(l.mst);
		// System.out.println(Arrays.toString(l.marked));
		System.out.println(l.weight());
	}
}