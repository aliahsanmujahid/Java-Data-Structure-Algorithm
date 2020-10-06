
package arraylist.to.an.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayListToAnArray {

    public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
     list.add("RAMr");
      list.add("JOHrN");
     list.add("DEVr");
     list.add("PETErR");
     list.add("JOHrN");
     
        System.out.println("List "+list);
      String[] strArray = new String[list.size()];
        list.toArray(strArray);
        for(String n:strArray){
            System.out.println(n);
        }
    }
    
}
