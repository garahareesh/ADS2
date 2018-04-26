import java.util.*;
public class ex
{
	int N;
	String[] aux;
	int [] count;
	int R;
	public ex(String [] a)
	{
		R=256;
		N = a.length;
		aux = new String[N];
		count = new int[R+1];
	// Compute frequency counts.
	for (int i = 0; i < N; i++)
		count[a[i].key() + 1]++;
	// Transform counts to indices.
	for (int r = 0; r < R; r++)
		count[r+1] += count[r];
	// Distribute the records.
	for (int i = 0; i < N; i++)
		aux[count[a[i].key()]++] = a[i];
	// Copy back.
	for (int i = 0; i < N; i++)
		a[i] = aux[i];
	}
	public static void main(String[] args) {
		String[] a={hareesh 1, msit 2, iiit 3, news 3, india 1};
		ex ob=new ex(a);
	}
}