import java.util.NoSuchElementException;
public class Graph
{
	private final int vertices;
	private int edges;
	Bag<Integer> adj[];
	Graph(int v)
	{
		this.vertices=v;
		this.edges=0;
		adj=(Bag<Integer>[]) new Bag[v];
		for(int i=0;i<v;i++)
			adj[i]=new Bag<Integer>();
	}
	int V()
	{
		return vertices;
	}
	int E()
	{
		return edges;
	}
	void isValidateVertex(int v)
	{
		if(v<0 || v>=vertices) throw new NoSuchElementException(" v not found:");

	}
	void addEdge(int v,int w)
	{
		isValidateVertex(v);
		isValidateVertex(w);
		edges++;
		adj[v].add(w);
		adj[w].add(v);
	}
	int degree(int v)
	{
		return adj[v].size();
	}
	String display()
	{
		String s="";
		for(int i=0;i<vertices;i++)
		{
			s=s+ i+":";
			for(int j:adj[i])
			{
				s=s+j+" ";
			}
			s=s+"\n";
		}
		return s;
	}
	public Iterable<Integer> adjacent(int v)
	{
		return adj[v];
	}
	public static void main(String[] args) {
		Graph graph = new Graph(13);
		graph.addEdge(0,5);
		graph.addEdge(4,3);
		graph.addEdge(9,12);
		graph.addEdge(6,4);
		graph.addEdge(5,4);
		graph.addEdge(0,1);
		graph.addEdge(11,12);
		graph.addEdge(0,2);
		graph.addEdge(9,10);
		graph.addEdge(0,6);
		graph.addEdge(7,8);
		graph.addEdge(9,11);
		graph.addEdge(5,3);

		System.out.println(graph.display());
	}
}