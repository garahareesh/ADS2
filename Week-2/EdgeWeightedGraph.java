import java.util.*;
public class EdgeWeightedGraph
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
			int selfLoops=0;
			for(Edge e:adj(v))
			{
				if(e.other(v)>v)
				{
					b.add(0,e);
				}
				else if(e.other(v)==v)
				{
					if(selfLoops%2==0)
						b.add(0,e);
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
		System.out.println(ewg.toString());
	}
}