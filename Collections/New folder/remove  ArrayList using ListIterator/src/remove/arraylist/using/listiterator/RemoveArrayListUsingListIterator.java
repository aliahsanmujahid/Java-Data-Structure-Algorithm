
package remove.arraylist.using.listiterator;

import java.util.ArrayList;
import java.util.ListIterator;

public class RemoveArrayListUsingListIterator {

    public static void main(String[] args) {
           ArrayList<String> list = new ArrayList<String>();
     list.add("RAMr");
     list.add("JOHrN");
     list.add("DEVr");
     list.add("PETErR");
     list.add("JOHrN");
     
    System.out.println("List "+list);
    ListIterator<String> litr = list.listIterator();
         while(litr.hasNext()){
        litr.next();
        litr.remove();
    }
         System.out.println("List "+list);
    
}
}
