
package arraylist.using.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListUsingIterator {

    public static void main(String[] args) {
      ArrayList<String> list = new ArrayList<String>();
     list.add("RAMr");
      list.add("JOHrN");
     list.add("DEVr");
     list.add("PETErR");
     list.add("JOHrN");
     
     System.out.println("List "+list);
     Iterator<String> itr = list.iterator();
     while(itr.hasNext()){
         itr.next();
         itr.remove();
     }
        System.out.println("After "+list);
    }
    
}
