 import java.util.ArrayList;  
 import java.util.Collections;  
 import java.util.*;  
 import java.util.Scanner;  
 
 public class LexicographicExample
 {
    public void lexicoGraphic(String s)
    {
      String t = s + s;
      int N = s.length();
      String[] rotation = new String[N];
      for (int i = 0; i < N; i++)
        rotation[i] = t.substring(i, i + N); 
      System.out.println(Arrays.toString(rotation));
      Arrays.sort(rotation);
      System.out.println("-------------------------------");
      System.out.println(Arrays.toString(rotation));
      System.out.println("Minimum:  "+rotation[0]);
      System.out.println("Maximum:  "+rotation[N-1]);
    }
 


      public static void main(String a[])
      {  
           Scanner sc = new Scanner(System.in);  
           System.out.println("Enter the String:-");  
           String str = sc.nextLine();  
           LexicographicExample l = new LexicographicExample();
           l.lexicoGraphic(str);
           // System.out.println("Enter the length");  
           // int count = sc.nextInt();  
           // List<String> list = new ArrayList<String>();  
           // for (int i = 0; i < str.length(); i = i + 1) {  
           //      if (str.length() - i >= count) {  
           //           list.add(str.substring(i, count + i));  
           //      }  
           // }  
           // Collections.sort(list);  
           // System.out.println("Smallest subString:-" + list.get(0));  
           // System.out.println("Largest subString:-" + list.get(list.size() - 1)); 
      }  
 }