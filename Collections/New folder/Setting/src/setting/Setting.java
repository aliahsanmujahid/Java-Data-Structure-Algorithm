
package setting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Setting {

    public static void main(String[] args) {
            ArrayList<String> list = new ArrayList<String>();
     list.add("RAMr");
     list.add("DEVr");
     list.add("PETErR");
     list.add("JOHrN");
     
        System.out.println("BEFORE"+list);
     list.set(3,"poipi");
        System.out.println("After Ratain"+list);
       
        boolean isExit = list.contains("poripi");
        System.out.println(isExit);
        
        String g =list.get(1);
        System.out.println(g);
    }
    
}
