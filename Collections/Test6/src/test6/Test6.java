
package test6;

import java.util.Enumeration;
import java.util.Vector;

public class Test6 {

    public static void main(String[] args) {
      Vector<String> v = new Vector<>();
      v.add("ratan");
      v.add("anu"); 
      v.add("durga");
      v.add("saryva");
      
      Enumeration e = v.elements();
      while(e.hasMoreElements()){
          String s = (String)e.nextElement();
          System.out.println(s); 
     }
      Enumeration<String> e1 = v.elements();
      while(e1.hasMoreElements()){
          String s = e1.nextElement();
          System.out.println(s);
      }
      
    }
    
}
