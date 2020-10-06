
package arraylist.and.get.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListAndGetObjects {

    public static void main(String[] args) {
     List<String> list = new ArrayList<String>();
     list.add("RAM");
     list.add("DEV");
     list.add("PETER");
     list.add("JOHN");
       // System.out.println(list);
       Iterator<String> itr = list.iterator();
       while(itr.hasNext()){
           String s = itr.next();
           System.out.println(s);
       }
     
       for(Iterator<String> itr2 = list.iterator();itr2.hasNext(); ){
           String s2 = itr2.next();
          System.out.println(s2);
      }   
             
             
             
      for(String name: list ){
          System.out.println(name);
      }       
    }
    
}
