
package remove;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Remove {

    public static void main(String[] args) {
       ArrayList<String> list = new ArrayList<String>();
     list.add("RAM");
     list.add("DEV");
     list.add("PETER");
     list.add("JOHN");
     list.remove("JOHN");
        System.out.println(list);
         Set<String> list2 = new HashSet<String>();
     list2.add("RAM");
     list2.add("DEV");
     list.removeAll(list2);
        System.out.println("After remove"+list);

    }
    
}
