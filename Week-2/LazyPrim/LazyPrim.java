import java.util.*;
class Edge implements Comparable<Edge>
{
	int v,w;
	double weight;
	public Edge(int v,int w, double weight)
	{
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	public int either()
	{
		return v;
	}
	public int other(int a)
	{
		if(a==v) return w; 
		return v;
	}
	public double weight()
	{
		return weight;
	}
	public int compareTo(Edge that)
	{
		// if(this.weight()>that.weight()) return 1;
		// else if(this.weight()<that.weight()) return -1;
		// else return 0;
		return Double.compare(this.weight, that.weight);
 	}
 	public String toString()
 	{
 		return String.format("%d-%d %.2f",v,w,weight);
 	}
}
// class EdgeWeightedGraph
// {
// 	private final int vertices;
// 	private int edges;
// 	ArrayList<Edge>[] bag;
// 	EdgeWeightedGraph(int v)
// 	{
// 		this.vertices=v;
// 		this.edges=0;
// 		bag=(ArrayList<Edge>[]) new ArrayList[v];
// 		for(int i=0;i<v;i++)
// 		{
// 			bag[i]=new ArrayList<Edge>();
// 		}
// 	}
// 	public int V()
// 	{
// 		return vertices;
// 	}
// 	public int E()
// 	{
// 		return edges;
// 	}
// 	public void addEdge(Edge e)
// 	{
// 		int v=e.either();
// 		int w=e.other(v);
// 		bag[v].add(0,e);
// 		bag[w].add(0,e);
// 		edges++;
// 	}
// 	public Iterable<Edge> adj(int v)
// 	{
// 		return bag[v];
// 	}
// 	public int degree(int v)
// 	{
// 		return bag[v].size();
// 	}
// 	public String toString()
// 	{
// 		String s="";
// 		for(int i=0;i<vertices;i++)
// 		{
// 			s+=i+":";
// 			for(Edge e:bag[i])
// 			{
// 				s+=e+" ";
// 			}
// 			s+="\n";
// 		}
// 		return s;
// 	}
// }
class EdgeWeightedGraph
{
	private final int V;
	private int E;
	ArrayList<Edge> [] adj;
	EdgeWeightedGraph(int V)
	{
		this.V=V;
		this.E=0;
		adj=(ArrayList<Edge>[]) new ArrayList[V];
		for(int v=0;v<V;v++)
			adj[v]=new ArrayList<Edge>();
	}	
	public void addEdge(Edge e)
	{
		int v=e.either();
		int w=e.other(v);
		adj[v].add(0,e);
		adj[w].add(0,e);
		E++;																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							
	}
	public int V()
	{
		return V;
	}
	public int E()
	{
		return E;
	}
	public Iterable<Edge> adj(int v)
	{
		return adj[v];
	}
	public int degree(int v)
	{
		return adj[v].size();
	}
	public Iterable<Edge> edges()
	{
		ArrayList<Edge> b=new ArrayList<Edge>();
		for(int v=0;v<V;v++){
			// int selfLoops=0;
			for(Edge e:adj(v))
			{
				// if(e.other(v)>v)
				// {
				// 	b.add(0,e);
				// }
				// else if(e.other(v)==v)
				// {
				// 	if(selfLoops%2==0)
				// 		b.add(0,e);
				// }
				if(!b.contains(e))
				{
					b.add(e);
				}
			}
		}
		// 	if(e.other(v)>v)
		// 		b.add(e);
		// return b;
		return b;
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<V;i++)
		{
			s+=i+":";
			for(Edge j:adj(i))
			{
				s+=j+" ";
			}
			s+="\n";
		}
		return s;
	}
	// public static void main(String[] args) {
	// 	Scanner sc=new Scanner(System.in);
	// 	int noOfvertices=Integer.parseInt(sc.nextLine());
	// 	int noOfedges=Integer.parseInt(sc.nextLine());
	// 	EdgeWeightedGraph ewg=new EdgeWeightedGraph(noOfvertices);
	// 	for(int i=0;i<noOfedges;i++)
	// 	{
	// 		String str=sc.nextLine();
	// 		String ss[]=str.split(" ");
	// 		Edge ob=new Edge(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]),Double.parseDouble(ss[2]));
	// 		ewg.addEdge(ob);
	// 	}
	// 	System.out.println(ewg.toString());
	// }
}
public class LazyPrim
{
	private boolean marked[];
	private double weight;
	private PriorityQueue<Edge> pq;
	private ArrayList<Edge> mst;
	LazyPrim(EdgeWeightedGraph G)
	{
		marked=new boolean[G.V()];
		pq=new PriorityQueue<Edge>();
		mst=new ArrayList<Edge>();
		for(int i=0;i<G.V();i++)
		{
			if(!marked[i])
				prim(G,i);
		}
	}
	private void prim(EdgeWeightedGraph G,int s)
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
	public void scan(EdgeWeightedGraph G, int v)
	{
		marked[v]=true;
		for(Edge e:G.adj(v))
		{
			if(!marked[e.other(v)])
				pq.add(e);
		}
		System.out.println(pq);
	}
	public Iterable<Edge> edges()
	{
		return mst;
	}
	public double weight()
	{
		System.out.println("weight is...");
		return weight;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOfvertices=Integer.parseInt(sc.nextLine());
		int noOfedges=Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph ewg=new EdgeWeightedGraph(noOfvertices);
		for(int i=0;i<noOfedges;i++)
		{
			String str=sc.nextLine();
			String ss[]=str.split(" ");
			Edge ob=new Edge(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]),Double.parseDouble(ss[2]));
			ewg.addEdge(ob);
		}
		LazyPrim lp=new LazyPrim(ewg);
		System.out.println(lp.weight());
		System.out.println(lp.mst);
	}
}

