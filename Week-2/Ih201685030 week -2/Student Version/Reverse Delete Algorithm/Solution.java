import java.util.*;
import java.lang.*;
public class Solution {
	ArrayList<Edge> bag;
	Stack<Edge> mst;
	boolean [] marked;
	EdgeWeightedGraph graph;
	Solution(EdgeWeightedGraph G)
	{
		this.graph=G;
		bag=new ArrayList<Edge>();
		mst=new Stack<Edge>();
		marked=new boolean[G.V()];
		for(Edge e:G.edges())
			bag.add(e);
		Collections.sort(bag);
		Collections.reverse(bag);
		// for(int i=0;i<bag.size();i++)
		// 	System.out.println(bag.get(i));
		reverseDelete();
	}
	public void reverseDelete()
	{
		int original_connect=connectedComponents(graph);
		int i=0;
		EdgeWeightedGraph temp=graph;
		while(i<bag.size())
		{
			Edge e=bag.get(i);
			temp.removeEdge(e);
			int delete_connect=connectedComponents(temp);
			if(delete_connect>original_connect)
			{
				temp.addEdge(e);
				mst.push(e);
			}
			i++;
		}
	}
	public int connectedComponents(EdgeWeightedGraph g)
	{
		marked=new boolean[g.V()];
		int count=0;
		for(int i=0;i<g.V();i++)
		{
			if(!marked[i]){
				dfs(g,i,marked);
				count++;
			}
		}
		return count;
	}
	public void dfs(EdgeWeightedGraph G,int s,boolean[]m)
	{
		m[s]=true;
		for(Edge e:G.adj(s))
		{
			int x=e.either();
			int y=e.other(x);
			if(x==s && !m[y]) dfs(G,y,m);
			if(y==s && !m[x]) dfs(G,x,m);
		}
	}
	public String display()
	{
		String s="";
		while(!mst.isEmpty())
		{
			Edge e=mst.pop();
			s+=e.toString()+"\n";
		}return s;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOfVertices=Integer.parseInt(sc.nextLine());
		int noOfEdges=Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph ewg=new EdgeWeightedGraph(noOfVertices);
		for(int i=0;i<noOfEdges;i++)
		{
			String str=sc.nextLine();
			String [] ss=str.split(" ");
			Edge ob=new Edge(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]),Integer.parseInt(ss[2]));
			ewg.addEdge(ob);
		}
		Solution ob=new Solution(ewg);
		System.out.println(ob.display());
		
	}
}