import java.util.*;
public class Solution {
	DirectedEdge [] edgeTo;
	double [] distTo;
	boolean [] marked;
	MinPQ<Integer> pq;
	int source;
	EdgeWeightedDigraph graph;
	public Solution(EdgeWeightedDigraph G)
	{
		this.graph=G;
		edgeTo=new DirectedEdge[G.V()];
		distTo=new double[G.V()];
		marked=new boolean[G.V()];
		pq=new MinPQ<Integer>();
		for(int i=0;i<G.V();i++)
		{
			distTo[i]=Double.POSITIVE_INFINITY;
		}
		distTo[0]=0.0;
		for(int i=0;i<G.V();i++){
			if(!marked[i]){
				marked[i]=true;
				pq.insert(i);
			}
		}
		// pq.insert(0);
		
		while(!pq.isEmpty())
		{
			int e=pq.delMin();
			relax(graph,e);
		}

	}
	public void relax(EdgeWeightedDigraph G,int source)
	{
		marked[source]=true;
		for(DirectedEdge ed:G.adj(source))
		{
			int w=ed.to();
			if(distTo[w]>distTo[source]+ed.weight())
			{
				distTo[w]=distTo[source]+ed.weight();
				edgeTo[w]=edgeTo[source];
				pq.insert(w);
			}
		}
	}
	public void display()
	{
		for(int i=0;i<graph.V();i++)
		{
			double d = Math.round(distTo[i]*100.0)/100.0;
			System.out.println("0 to "+i+" : "+d);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOfVertices=Integer.parseInt(sc.nextLine());
		int noOfEdges=Integer.parseInt(sc.nextLine());
		EdgeWeightedDigraph ewg=new EdgeWeightedDigraph(noOfVertices);
		for(int i=0;i<noOfEdges;i++)
		{
			String str=sc.nextLine();
			String [] ss=str.split(" ");
			DirectedEdge ob=new DirectedEdge(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]),Double.parseDouble(ss[2]));
			ewg.addEdge(ob);
		}
		Solution ob=new Solution(ewg);
		ob.display();

		
	}
}