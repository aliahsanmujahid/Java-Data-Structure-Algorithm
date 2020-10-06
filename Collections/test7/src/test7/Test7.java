
package test7;

import java.util.ArrayList;
import java.util.Iterator;

public class Test7 {

    public static void main(String[] args) {
      ArrayList<String> ar= new ArrayList<>();
      ar.add("ratan");
      ar.add("anu"); 
      ar.add("durga");
      ar.add("saryva");
      
      Iterator itr  = ar.iterator();
      while(itr.hasNext()){
          String s = (String) itr.next();
          System.out.println(s);
                 
                  
      }
            Iterator<String> itr1  = ar.iterator();
      while(itr.hasNext()){
          String s =  itr1.next();
          System.out.println(s);
                 
                  
      }
    }
}
