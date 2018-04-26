import java.util.*;
public class Edge implements Comparable<Edge>
{
	int v;
	int w;
	double weight;
	Edge(int v,int w, double weight)
	{
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	public double weight()
	{
		return weight;
	}
	public int either()
	{
		return v; 
	}
	public int other(int a)
	{
		if(a==v) return w;
		return v;
	}
	public int compareTo(Edge that)
	{
		if(this.weight()<that.weight()) return -1;
		else if(this.weight()>that.weight()) return 1;
		else return 0;
		// return Double.compare(this.weight,that.weight);
	}
	public String toString()
	{
		return v+","+w+","+weight;
		// System.out.println("hello");
		// System.out.println();
		// return String.format("%d-%d %.2f",v,w,weight);
	}
	public static void main(String[] args) {
		// Scanner sc=new Scanner(System.in);
		// int vertices=Integer.parseInt(sc.nextLine());
		// int edges=Integer.parseInt(sc.nextLine());
		
		// for(int i=0;i<edges;i++)
		// {
		// 	String str=sc.nextLine();
		// 	String [] ss=str.split(" ");
		// 	Edge ob=new Edge(Integer.parseInt(ss[0]),Integer.parseInt(ss[1]),Double.parseDouble(ss[2]));	
		// 	System.out.println(ob.toString());
		// }
		
		
	}
}