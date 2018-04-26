import java.util.*;
class Node<Value>
{
    int R = 256;
    Object val;
    Node[] next=new Node[R];
}
public class TrieST<Value>
{
    Node root;
    int R = 256;
    public TrieST()
    {

    }
    public void put(String key,Value val)
    {
        root = put(root, key, val, 0);
    }

    public Node put(Node x,String key,Value val,int d)
    {
        if(x==null)
            x=new Node();
        if(d==key.length())
        {
            x.val=val;
            return x;
        }
        char c=key.charAt(d);
        x.next[c]=put(x.next[c],key,val,d+1);
        return x;
    }

    public void floor(String key)
    {
        ArrayList<String> al = keys();
        if(al.contains(key))
            System.out.println(key);
        else
        {
            int i = 0;
            for(i=0; i<al.size(); i++)
            {
                if(al.get(i).compareTo(key)>0)
                {
                    // System.out.println(i);
                    break;
                }
            }
            if(i==0)
                  System.out.println(al.get(i));
            else
                System.out.println(al.get(i-1));
        }
    }

    public void ceil(String key)
    {
        ArrayList<String> al = keys();
        if(al.contains(key))
            System.out.println(key);
        else
        {
            int i = 0;
            for(i=0; i<al.size(); i++)
            {
                if(al.get(i).compareTo(key)>0)
                {
                    // System.out.println(i);
                    break;
                }
            }
            System.out.println(al.get(i));
        }
    }
    public int rank(String key)
    {
        ArrayList<String> al=keys();
        for (int i=0; i<al.size(); i++)
        {
            if (al.get(i).equals(key))
            {
                return i;
            }
        }
        return -1;
    }

public String select(int k)
    {
        ArrayList<String> al=keys();
        return al.get(k);
    }

    public Value get(String key)
    {
        Node x=get(root,key,0);
        if(x==null)
            return null;
        return (Value)x.val;
    }

    public Node get(Node x,String key,int d)
    {
        if(x==null)
            return null;
        if(d==key.length())
            return x;
        char c=key.charAt(d);
        return get(x.next[c],key,d+1);
    }

    public void collect(Node x,String prefix,ArrayList<String> queue)
    {
        if(x==null)
            return;
        if(x.val!=null)
            queue.add(prefix);
        for(char c=0;c<R;c++)
            collect(x.next[c],prefix+c,queue);
    }

    public ArrayList<String> keys()
    {
        return keysWithPrefix("");
    }

    public ArrayList<String> keysWithPrefix(String prefix)
    {
        ArrayList<String> queue=new ArrayList<String>();
        Node x=get(root,prefix,0);
        collect(x,prefix,queue);
        return queue;
    }


    public static void main(String[] args)
    {
        TrieST t = new TrieST();
        t.put("she", 1);
        t.put("sells", 1);
        t.put("sea", 1);
        t.put("shells", 1);
        t.put("by", 1);
        t.put("the", 1);
        t.put("sea",10);
        t.put("shore", 25);
        System.out.println(t.keys());
        System.out.println(t.keysWithPrefix("sh"));
        t.floor("shell");
        t.ceil("raa");
    }
}

// test_data = ['she', 'sells', 'sea', 'shells', 'by', 'the', 'sea', 'shore']
