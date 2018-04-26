import java.util.*;
import java.lang.*;
class Edge implements Comparable<Edge>
{
	int v,w;
	double weight;
	Edge(int v,int w,double weight)
	{
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	public  int either()
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
		return Double.compare(this.weight,that.weight);
	}
	public String toString()
	{
		return v+"->"+w+" "+weight;
	}
}
class EdgeWeightedGraph
{
	private final int vertices;
	int E;
	private ArrayList<Edge>[] bag;
	EdgeWeightedGraph(int v)
	{
		this.vertices=v;
		this.E=0;
		bag=(ArrayList<Edge>[])new ArrayList[v];
		for(int i=0;i<vertices;i++)
		{
			bag[i]=new ArrayList<Edge>();
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
	public void addEdge(Edge e)
	{
		int v=e.either();
		int w=e.other(v);
		bag[v].add(e);
		bag[w].add(e);
		E++;
	}
	public void removeEdge(Edge e)
	{
		int v=e.either();
		int w=e.other(v);
		for(int i=0;i<bag[v].size();i++)
		{
			Edge temp=bag[v].get(i);
			if(temp.other(v)==w) bag[v].remove(i);
		}
		for(int i=0;i<bag[w].size();i++)
		{
			Edge temp=bag[w].get(i);
			if(temp.other(w)==v) bag[w].remove(i);
		}
	}
	public Iterable<Edge>adj(int v)
	{
		return bag[v];
	}
	public Iterable<Edge> edges()
	{
		ArrayList<Edge> b=new ArrayList<Edge>();
		for(int i=0;i<vertices;i++)
		{
			for(Edge e:bag[i])
			{
				if(!b.contains(e))
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
			for(Edge j:bag[i])
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
public class ReverseDelete
{
	EdgeWeightedGraph graph;
	Queue<Edge> mst;
	boolean [] marked;
	int count;
	double weight;
	ArrayList<Edge> al;
	ReverseDelete(EdgeWeightedGraph G)
	{
		this.graph=G;
		mst=new LinkedList<Edge>();
		marked=new boolean[graph.V()];
		this.count=0;
		al=new ArrayList<Edge>();
		// this.al=graph.b;
		addingEdges(graph);
		reverseDelete();
	}
	public void addingEdges(EdgeWeightedGraph g)
	{
		for(int i=0;i<g.V();i++)
		{
			for(Edge e:g.adj(i))
			{
				if(!al.contains(e))
					al.add(e);
			}
		}
		Collections.sort(al);
		// for(int i=0;i<al.size();i++)
		// 	System.out.println(al.get(i).toString());
		
		Collections.reverse(al);
	}
	public void reverseDelete()
	{
		int original_connected=connectedComponents(graph);
		EdgeWeightedGraph temp=graph;
		int i=0;
		while(i<al.size())
		{
			Edge e=al.get(i);
			temp.removeEdge(e);
			int afterdeleted_connected=connectedComponents(temp);
			if(afterdeleted_connected>original_connected)
			{
				temp.addEdge(e);
				mst.add(e);
				weight+=e.weight();
			}
			i++;
		}
		String s=display();
		System.out.println("mst");
		System.out.println(s);
	}
	public int connectedComponents(EdgeWeightedGraph g)
	{
		int count=0;
		boolean[] marked=new boolean[g.V()];
		for(int i=0;i<g.V();i++)
		{
			if(!marked[i]){
				dfs(g,i,marked);
				count++;
			}
		}
		return count;
	}
	public void dfs(EdgeWeightedGraph g,int s, boolean[] m)
	{
		m[s]=true;
		for(Edge e:g.adj(s))
		{
			int x=e.either();
			int y=e.other(x);
			if(x==s && !m[y]) dfs(g,y,m);
			else if(y==s && !m[x]) dfs(g,x,m);
		}
	}
	public double weight()
	{
		return weight;
	}
	public String display()
	{
		String s="";
		while(!mst.isEmpty())
		{
			Edge e=mst.remove();
			s+=e.toString()+"\n";
		}
		return s;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(vertices);

		for(int i = 0; i<edges; i++)
		{
			String s = sc.nextLine();
			String[] st = s.split(" ");
			int v = Integer.parseInt(st[0]);
			int w = Integer.parseInt(st[1]);
			double wt = Double.parseDouble(st[2]);
			Edge edge = new Edge(v,w,wt);
			ewg.addEdge(edge);
			

		}
		ReverseDelete rev = new ReverseDelete(ewg);
		System.out.println(rev.weight());
}

}
