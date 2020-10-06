
package test.pkg5;

import java.util.ArrayList;
import java.util.Collections;

public class Test5 {

    public static void main(String[] args) {
      ArrayList <String> a1 = new ArrayList();
      a1.add("ratan");
      a1.add("NU");
      a1.add("DURGA");
      a1.add("sravya");
        System.out.println("Befor "+a1);
        Collections.swap(a1, 1, 2);
        System.out.println("After "+a1);
        ArrayList<String> a2 = new ArrayList(a1.subList(1,4));
        a2.add("aaa");
        System.out.println(a2);
    }
    
}
