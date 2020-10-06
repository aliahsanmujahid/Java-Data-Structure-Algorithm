
package sublist.from.the.arraylist;

import java.util.ArrayList;
import java.util.List;

public class SubListFromTheArrayList {

    public static void main(String[] args) {
                            ArrayList<String> list = new ArrayList<String>();
     list.add("RAMr");
      list.add("JOHrN");
     list.add("DEVr");
     list.add("PETErR");
     list.add("JOHrN");
     
        System.out.println("BEFORE "+list);
        List<String> sublist = list.subList(1, 4);
        System.out.println(sublist);
    }
    
}
