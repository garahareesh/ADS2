import java.util.*;
public class ReverseAlgorithm
{
	ArrayList<Edge> sort=new ArrayList<Edge>();
	double weight;
	Queue<Edge> mst=new LinkedList<Edge>();
	EdgeWeightedGraph G;
	public ReverseAlgorithm(EdgeWeightedGraph G)
	{
		// this.G=new EdgeWeightedGraph G;
		weight=0.0;
		for(Edge e:G.edges())
			sort.add(e);
		Collections.sort(sort);

	}
	public void revere()
	{
		for(int i=sort.size()-1;i>=0;i--)
		{
			G.adj.remove(i);
			G.adj.remove(i-1);
		}
	}

}