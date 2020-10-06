
package add.set.to.the.arraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddSetToTheArrayList {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
     list.add("RAM");
     list.add("DEV");
     list.add("PETER");
     list.add("JOHN");
        System.out.println(list);
         Set<String> list2 = new HashSet<String>();
     list2.add("RAM2");
     list2.add("DEV2");
     list2.add("PETER2");
     list2.add("JOHN2");
        System.out.println(list2);
        list.addAll(list2);
        System.out.println("After Adding");
        System.out.println(list);
    }
    
}
