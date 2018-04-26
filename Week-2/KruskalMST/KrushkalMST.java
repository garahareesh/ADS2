import java.util.*;
class UnionFind
{
	int p,q;
	int[]id;
	int k;
	UnionFind(int k)
	{
		this.k=k;
		id=new int[k];
		for(int i=0;i<k;i++)
		{
			id[i]=i;
		}
	}
	public int find(int i)
	{
		return id[i];
	}
	public void union(int p,int q)
	{
		 p=find(p);
		 q=find(q);
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
public class KrushkalMST
{
	private double weight;
	private Queue<Edge>mst=new LinkedList<Edge>();
	public KrushkalMST(EdgeWeightedGraph G)
	{
		PriorityQueue<Edge> pq=new PriorityQueue<Edge>();
		for(Edge e:G.edges())
			pq.add(e);
		UnionFind uf=new UnionFind(G.V());
		while(!pq.isEmpty() && mst.size()<G.V()-1)
		{
			Edge e=pq.poll();
			int v=e.either();
			int w=e.other(v);
			if(!uf.connected(v,w))
			{
				uf.union(v,w);
				mst.add(e);
				weight+=e.weight();
			}
		}
	}
	public Iterable<Edge> edges()
	{
		return mst;
	}
	public double weight()
	{
		return weight;
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
		KrushkalMST km=new KrushkalMST(ewg);
		System.out.println(km.weight());
		System.out.println(km.edges());

	}
}