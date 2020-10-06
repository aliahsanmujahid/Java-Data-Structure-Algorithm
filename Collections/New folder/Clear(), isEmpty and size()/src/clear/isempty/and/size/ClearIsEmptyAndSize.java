
package clear.isempty.and.size;

import java.util.ArrayList;

public class ClearIsEmptyAndSize {

    public static void main(String[] args) {
                        ArrayList<String> list = new ArrayList<String>();
     list.add("RAMr");
      list.add("JOHrN");
     list.add("DEVr");
     list.add("PETErR");
     list.add("JOHrN");
     
        System.out.println("BEFORE"+list);
        
        int  size = list.size();
         boolean isEmpty= list.isEmpty();
        

        System.out.println(size);
        System.out.println(isEmpty);
        
        list.clear();
        isEmpty= list.isEmpty();
        System.out.println(isEmpty);
        System.out.println(list);
        System.out.println();
    }
    
}
