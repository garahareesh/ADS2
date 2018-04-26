import java.util.*;
class Graph
{
	private final int vertices;
	int edges;
	ArrayList<Integer> [] arr;
	public Graph(int v)
	{
		this.vertices=v;
		this.edges=0;
		arr=(ArrayList<Integer>[])new ArrayList[v];
		for(int i=0;i<vertices;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
	}
	public void addEdge(int v,int w)
	{
		arr[v].add(w);
		arr[w].add(v);
		edges++;
	}
	public int V()
	{
		return vertices;
	}
	public int E()
	{
		return edges;
	}
	public Iterable<Integer> adj(int v)
	{
		return arr[v];
	}
}
public class Solution {
	
	boolean marked[];
	int edgeTo[];
	int dist[];
	// int min;
	int source;
	public Solution(Graph G, int source)
	{
		this.source=source;
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		dist=new int[G.V()];
		// for(int i=0;i<edgeTo.length;i++){
		// 	if(!marked[i])
		// 		bfs(G,i);
		// }
		bfs(G,source);
	}
	public void bfs(Graph G, int s)
	{
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(s);
		// dist[s]=0;
		marked[s]=true;
		while(!q.isEmpty())
		{
			int temp=q.remove();
			for(int w:G.adj(temp))
			{
				if(!marked[w])
				{
					edgeTo[w]=temp;
					marked[w]=true;
					dist[w]=dist[temp]+1;
					q.add(w);
				}
			}
		}
	}
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	public void shortest(Graph G)
	{
		for(int i=0;i<G.V();i++)
		{
			if(hasPathTo(i))
				System.out.println(i+":"+dist[i]);
		}
	}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int noOfVertices=Integer.parseInt(sc.nextLine());
        int noOfEdges=Integer.parseInt(sc.nextLine());
        int sourceVertex=Integer.parseInt(sc.nextLine());
        Graph g=new Graph(noOfVertices);
        for(int i=0;i<noOfEdges;i++)
        {
        	String str=sc.nextLine();
        	String[] ss=str.split(" ");
        	g.addEdge(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]));
        }
        Solution ob=new Solution(g,sourceVertex);
        // System.out.println(ob.pathTo(sourceVertex));
        ob.shortest(g);
    }
}