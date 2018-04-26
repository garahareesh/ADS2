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
	public int other(int v)
	{
		if(v==v) return w;
		else 
			return v;
	}
	public int compareTo(Edge that)
	{
		if(this.weight>that.weight) return 1;
		else if(this.weight<that.weight) return -1;
		else return 0;
 	}
}