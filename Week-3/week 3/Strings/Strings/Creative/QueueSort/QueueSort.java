import java.util.*;
class QueueSort{
	static int R=256;
	public static String sort(String s)
	{
		String[] arr=s.split(" ");
		QueueADT<String> q=new QueueADT();
		for(String e:arr) q.enqueue(e);
		q=sort(q,0);
		String ss="";
		for(int i=0;i<q.size();i++)
			ss+=(String)q.get(i)+" ";
		
		return ss.trim();
	}
	public static int charAt(String s, int d)
	{
		if(d>=s.length()) return -1;
		return s.charAt(d);
	}
	public static QueueADT sort(QueueADT q,int d)
	{
		QueueADT<String>[] arr=new QueueADT[R];
		QueueADT<String> aux=new QueueADT();
		if(q.size()<=1) return q;
		for(int i=0;i<q.size();i++)
		{
			String temp=(String)q.get(i);
			if(charAt(temp,d)==-1){
				aux.enqueue(temp);
				continue;
			}
			if(arr[temp.charAt(d)]==null)
				arr[temp.charAt(d)]=new QueueADT();
			arr[temp.charAt(d)].enqueue(temp);
		}
		for(int i=0;i<R;i++)
		{
			if(arr[i]!=null)
				arr[i]=sort(arr[i],d+1);
		}
		for(int r=0;r<R;r++)
		{
			if(arr[r]!=null){
				QueueADT temp=arr[r];
				for(int i=0;i<temp.size();i++)
					aux.enqueue((String)temp.get(i));
			}
		}
		return aux;
	}
	public static void main(String[] args) {
		QueueSort qsort= new QueueSort();
		// String result=qsort.sort("she sells sea shells on sea shore");
		String result=qsort.sort("hi jaffa ga aaa");
		System.out.println(result);
	}
}