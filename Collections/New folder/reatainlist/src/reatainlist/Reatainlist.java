
package reatainlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Reatainlist {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
     list.add("RAMr");
     list.add("DEVr");
     list.add("PETErR");
     list.add("JOHrN");
     
        System.out.println(list);
         Set<String> list2 = new HashSet<String>();
     list2.add("RAMr");
     list2.add("DEV");
     list.retainAll(list2);
        System.out.println("After Ratain"+list);
    }
    
}
