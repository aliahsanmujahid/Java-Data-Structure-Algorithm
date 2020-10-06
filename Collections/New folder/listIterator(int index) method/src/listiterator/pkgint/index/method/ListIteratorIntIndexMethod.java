
package listiterator.pkgint.index.method;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorIntIndexMethod {

    public static void main(String[] args) {
     ArrayList<String> list = new ArrayList<String>();
     list.add("RAMr");
     list.add("JOHrN");
     list.add("DEVr");
     list.add("PETErR");
     list.add("JOHrN");
     
    System.out.println("List "+list);
    ListIterator<String> litr = list.listIterator(2);
         while(litr.hasNext()){
        int nextIndex = litr.nextIndex();
         String name  = litr.next();
         System.out.print(name);
         System.out.print("["+nextIndex+"] ");
     }
    }
    
}
