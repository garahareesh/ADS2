import java.util.*;
class UnionFind
{
	// int p,q;
	int k;
	int [] id;
	UnionFind(int k)
	{
		id=new int[k];
		for(int i=0;i<k;i++)
		{
			id[i]=i;
		}
	}
	public int find(int p)
	{
		return id[p];
	}
	public void union(int x,int y)
	{
		int p=find(x);
		int q=find(y);
		for(int i=0;i<k;i++)
		{
			if(id[i]==p)
				id[i]=q;
		}
	}
	public boolean connected(int p,int q)
	{
		return id[p]==id[q];
	}
}
public class Krushkal
{
	 Queue<Edge> mst=new LinkedList<Edge>();
	 double weight;
	 PriorityQueue<Edge> pq;
	public Krushkal(EdgeWeightedGraph G)
	{
		pq=new PriorityQueue<Edge>();
		weight=0.0;
		for(Edge e:G.edges()){
				pq.add(e);
		}
		System.out.println(pq);
		// System.out.println("hello");
		UnionFind uf=new UnionFind(G.V());
		while(!pq.isEmpty() && mst.size()<G.V()-1)
		{
			Edge e=pq.poll();
			int v=e.either();
			int w=e.other(v);
			if(!uf.connected(v,w))
			{
				// System.out.println("hi hllpo");
				uf.union(v,w);
				mst.add(e);
				weight+=e.weight();
			}
		}
		// System.out.println("hello...."+pq);
	}
	public double weight()
	{
		return weight;
	}
	public Iterable<Edge> edges()
	{
		return mst;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOfVertices=Integer.parseInt(sc.nextLine());
		int noOfEdges=Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph ewg=new EdgeWeightedGraph(noOfVertices);
		for(int i=0;i<noOfEdges;i++)
		{
			String str=sc.nextLine();
			String[] ss=str.split(" ");
			Edge ob=new Edge(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]),Double.parseDouble(ss[2]));
			ewg.addEdge(ob);
		}
		Krushkal km=new Krushkal(ewg);
		System.out.println(km.weight());
		System.out.println(km.edges());

	}
}