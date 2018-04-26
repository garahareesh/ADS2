
/******************************************************************************
 *  Compilation:  javac TST.java
 *  Execution:    java TST < words.txt
 *  Dependencies: StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/52trie/shellsST.txt
 *
 *  Symbol table with string keys, implemented using a ternary search
 *  trie (TST).
 *
 *
 *  % java TST < shellsST.txt
 *  keys(""):
 *  by 4
 *  sea 6
 *  sells 1
 *  she 0
 *  shells 3
 *  shore 7
 *  the 5
 *
 *  longestPrefixOf("shellsort"):
 *  shells
 *
 *  keysWithPrefix("shor"):
 *  shore
 *
 *  keysThatMatch(".he.l."):
 *  shells
 *
 *  % java TST
 *  theory the now is the time for all good men
 *
 *  Remarks
 *  --------
 *    - can't use a key that is the empty string ""
 *
 ******************************************************************************/
import java.util.*;
public class TST<Value> 
{
    private int n;              // size
    private Node<Value> root;   // root of TST

    private static class Node<Value> 
    {
        private char c;                        // character
        private Node<Value> left, mid, right;  // left, middle, and right subtries
        private Value val;                     // value associated with string
    }

    /**
     * Initializes an empty string symbol table.
     */
    public TST() {
    }

    /*
     Returns the number of key-value pairs in this symbol table.
     */
    public int size() {
        return n;
    }

    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *     {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(String key) 
    {
        if (key == null) 
        {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    /*
     Returns the value associated with the given key.
     */
    public Value get(String key) 
    {
        if (key == null) 
        {
            throw new IllegalArgumentException("calls get() with null argument");
        }
        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
        Node<Value> x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    // return subtrie corresponding to given key
    private Node<Value> get(Node<Value> x, String key, int d) 
    {
        if (x == null) return null;
        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
        char c = key.charAt(d);
        if      (c < x.c)              return get(x.left,  key, d);
        else if (c > x.c)              return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid,   key, d+1);
        else                           return x;
    }

    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table.
     * If the value is {@code null}, this effectively deletes the key from the symbol table.
     */
    public void put(String key, Value val)
    {
        if (key == null) 
        {
            throw new IllegalArgumentException("calls put() with null key");
        }
        if (!contains(key)) n++;
        root = put(root, key, val, 0);
    }

    private Node<Value> put(Node<Value> x, String key, Value val, int d) 
    {
        char c = key.charAt(d);
        if (x == null) 
        {
            x = new Node<Value>();
            x.c = c;
        }
        if      (c < x.c)               x.left  = put(x.left,  key, val, d);
        else if (c > x.c)               x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1)  x.mid   = put(x.mid,   key, val, d+1);
        else                            x.val   = val;
        return x;
    }

    /**
     * Returns the string in the symbol table that is the longest prefix of {@code query},
     * or {@code null}, if no such string.
   */
    public String longestPrefixOf(String query) 
    {
        if (query == null) 
        {
            throw new IllegalArgumentException("calls longestPrefixOf() with null argument");
        }
        if (query.length() == 0) return null;
        int length = 0;
        Node<Value> x = root;
        int i = 0;
        while (x != null && i < query.length()) 
        {
            char c = query.charAt(i);
            if      (c < x.c) x = x.left;
            else if (c > x.c) x = x.right;
            else 
            {
                i++;
                if (x.val != null) length = i;
                x = x.mid;
            }
        }
        return query.substring(0, length);
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     */
    public Iterable<String> keys() 
    {
        Queue<String> queue = new LinkedList<String>();
        collect(root, new StringBuilder(), queue);
        return queue;
    }

    /**
     * Returns all of the keys in the set that start with prefix.
     */
    public Iterable<String> keysWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("calls keysWithPrefix() with null argument");
        }
        Queue<String> queue = new LinkedList<String>();
        Node<Value> x = get(root, prefix, 0);
        if (x == null) return queue;
        if (x.val != null) queue.add(prefix);
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
    }

    // all keys in subtrie rooted at x with given prefix
    private void collect(Node<Value> x, StringBuilder prefix, Queue<String> queue) 
    {
        if (x == null) return;
        collect(x.left,  prefix, queue);
        if (x.val != null)
        {
            queue.add(prefix.toString() + x.c);
        } 
        collect(x.mid,   prefix.append(x.c), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, queue);
    }


    /**
     * Returns all of the keys in the symbol table that match {@code pattern},
     * where . symbol is treated as a wildcard character.
     */
    public Iterable<String> keysThatMatch(String pattern) 
    {
        Queue<String> queue = new LinkedList<String>();
        collect(root, new StringBuilder(), 0, pattern, queue);
        return queue;
    }
 
    private void collect(Node<Value> x, StringBuilder prefix, int i, String pattern, Queue<String> queue) 
    {
        if (x == null) return;
        char c = pattern.charAt(i);
        if (c == '.' || c < x.c) collect(x.left, prefix, i, pattern, queue);
        if (c == '.' || c == x.c) 
        {
            if (i == pattern.length() - 1 && x.val != null) queue.add(prefix.toString() + x.c);
            if (i < pattern.length() - 1) 
            {
                collect(x.mid, prefix.append(x.c), i+1, pattern, queue);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        if (c == '.' || c > x.c) collect(x.right, prefix, i, pattern, queue);
    }

    //display
    // public String toString()
    // {
    //     String s="";
    //     while(root.next!=null)
    //     {
    //         s+=root.left+" "+root.mid+" "+root.right;
    //         root=root.next;
    //     }
    // }

    public static void main(String[] args) 
    {

        // build symbol table from standard input
        TST<Integer> st = new TST<Integer>();
        st.put("now",1);
        st.put("is",2);
        st.put("the",3);
        st.put("time",4);
        st.put("for",5);
        st.put("all",6);
        st.put("good",7);
        st.put("people",8);
        st.put("to",9);
        st.put("come",10);
        st.put("to",11);
        st.put("the",12);
        st.put("aid",13);
        st.put("of",14);

        // System.out.println(st.contains("peopless"));
        //--------------------------------Scanner Input----------------------------------------------
        // Scanner sc=new Scanner(System.in);
        // int n=Integer.parseInt(sc.nextLine());
        // for (int i=0;i<n;i++ ) 
        // {
        //     String s=sc.nextLine();
        //     String[] a=s.split(" ");
        //     st.put(a[0],Integer.parseInt(a[1]));            
        // }
        // System.out.println("------output-----------");
        // for (String key : st.keys()) 
        // {
        //         System.out.println(key + " " + st.get(key));
        // }

        // System.out.println("-------longestPrefixOf-------");
        // String s=sc.nextLine();
        // System.out.println("---output-----");
        // System.out.println(st.longestPrefixOf(s));


        // System.out.println("-------keysWithPrefix-------");
        // String w=sc.nextLine();
        // System.out.println("---output-----");
        // for (String q : st.keysWithPrefix(w))
        // {
        //     System.out.println(q);
        // }

        // System.out.println("--------keysThatMatch-------");
        // String e=sc.nextLine();
        // System.out.println("---output-----");
        // for (String q : st.keysThatMatch(e))
        // {
        //     System.out.println(q);
        // }        

        //-----------------------Normal(User) Input----------------------------------
        // st.put("she",1);
        // st.put("shell",2);
        // st.put("shellsort",3);
        // st.put("shelter",5);
        // st.put("by",8);

        // // System.out.println(st.get("people"));
        // System.out.println("keys(\"\"):");
        // for (String key : st.keys()) 
        // {
        //         System.out.println(key + " " + st.get(key));
        // }

        // System.out.println("-------longestPrefixOf-------");
        // System.out.println(st.longestPrefixOf("byear"));

        // System.out.println("-------keysWithPrefix-------");
        // for (String s : st.keysWithPrefix("sh"))
        // {
        //     System.out.println(s);
        // }

        // System.out.println("--------keysThatMatch-------");
        // for (String s : st.keysThatMatch(".hell"))
        // {
        //     System.out.println(s);
        // }
    }
}
