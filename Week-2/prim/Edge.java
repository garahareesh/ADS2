import java.util.*;
public class Edge implements Comparable<Edge>
{
	int v,w;
	double weight;
	public Edge(int v,int w,double weight)
	{
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	public double weight()
	{
		return weight;
	}
	public int compareTo(Edge that)
	{
		if(this.weight()>that.weight()) return 1;
		else if(this.weight()<that.weight()) return -1;
		else return 0;
	}
	public int either()
	{
		return v;
	}
	public int other(int v)
	{
		if(v==v) return w;
		return v;
	}
	public String toString()
	{
		return String.format("%d-%d %.2f",v,w,weight);
	}
}