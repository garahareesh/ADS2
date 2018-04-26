import java.util.*;
public class QueueSort{
	private static int R=256;

	public static int charAt(String s,int i){
		if(i>=s.length())
			return -1;
		return (int)s.charAt(i);
	}
	
	public static String sort(String s){
		QueueADT q=new QueueADT();
		
		String[] input=s.split(" ");
		String result="";
		//aux=new int[input.length];
		for(String iter:input)
			q.enqueue(iter);

		q=sort(q,0);
		
		for(int i=0;i<q.size();i++)
			result+=(String)q.get(i)+" ";
		
		return result.trim();
	}

	public static QueueADT sort(QueueADT input,int d){

		QueueADT[] array=new QueueADT[R];
		QueueADT auxArray=new QueueADT();

		if(input.size()==1)
			return input;

		for(int i=0;i<input.size();i++){
			String temp=(String)input.get(i);

			if(charAt(temp,d)==-1){
				auxArray.enqueue(temp);
				continue;
			}

			if(array[temp.charAt(d)]==null)
				array[temp.charAt(d)]=new QueueADT();
			array[temp.charAt(d)].enqueue(temp);

		}

		for(int i=0;i<R;i++){
			if(array[i]!=null)
				array[i]=sort(array[i],d+1);
		}


		for(int i=0;i<R;i++){
			if(array[i]!=null){
				QueueADT temp=array[i];
				for(int j=0;j<temp.size();j++)
					auxArray.enqueue(temp.get(j));
			}
		}

		return auxArray;

		
	}
	public static void main(String[] args) {
		QueueSort qsort= new QueueSort();
		// String result=qsort.sort("she sells sea shells on sea shore");
		String result=qsort.sort("hi jaffa ga");
		System.out.println(result);
	}
}