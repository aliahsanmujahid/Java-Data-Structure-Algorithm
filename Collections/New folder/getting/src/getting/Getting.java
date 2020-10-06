
package getting;

import java.util.ArrayList;

public class Getting {

    public static void main(String[] args) {
                  ArrayList<String> list = new ArrayList<String>();
     list.add("RAMr");
      list.add("JOHrN");
     list.add("DEVr");
     list.add("PETErR");
     list.add("JOHrN");
     
        System.out.println("BEFORE"+list);

        
        String g =list.get(1);
        System.out.println(g);
        
        int index = list.indexOf("JOHrN");
        System.out.println("Index = "+index);
         int index2 = list.lastIndexOf("JOHrN");
        System.out.println("Index = "+index2);
    }
    
}
