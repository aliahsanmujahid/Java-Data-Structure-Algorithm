
package add.a.group.of.objects.to.the.arraylist;

import java.util.ArrayList;
import java.util.List;

public class AddAGroupOfObjectsToTheArrayList {

    public static void main(String[] args) {
      List<String> list = new ArrayList<String>();
     list.add("RAM");
     list.add("DEV");
     list.add("PETER");
     list.add("JOHN");
        System.out.println(list);
         List<String> list2 = new ArrayList<String>();
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
