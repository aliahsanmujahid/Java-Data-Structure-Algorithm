
package test8;

import java.util.ArrayList;
import java.util.Iterator;

public class Test8 {
    public static void main(String[] args) {
      ArrayList<String> ar= new ArrayList<>();
      ar.add("ratan");
      ar.add("anu"); 
      ar.add("durga");
      ar.add("saryva");
      
   /*   ListIterator itr  = ar.listIterator();
      while(itr.hasNext()){
          String s = (String) itr.next();
          System.out.println(s);
                 
                  
      }*/
     Iterator<String> itr  = ar.iterator();
      while(itr.hasNext()){
          String s =  itr.next();
          if(s.equals("anu"))
          itr.remove();
      }
      System.out.println(ar);
    }
    
}
