
package replace.an.element.in.the.arraylist;

import java.util.ArrayList;
import java.util.ListIterator;

public class ReplaceAnElementInTheArrayList {

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
        int pos = litr.nextIndex();
        if(pos==2){
            litr.add("www");
        }
         String name  = litr.next();
        if(name.equalsIgnoreCase("JOHrN")){
            litr.set("http");
        }
    }
     System.out.println("\nList "+list);
    }
    
}
