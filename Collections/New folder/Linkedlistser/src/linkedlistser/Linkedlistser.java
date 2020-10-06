
package linkedlistser;

import java.util.HashSet;
import java.util.LinkedList;

public class Linkedlistser {

    public static void main(String[] args) {
            HashSet<Integer> hset = new HashSet<>();
      hset.add(100);
       hset.add(200);
        hset.add(300);
        System.out.println("Hashset :"+hset);
        LinkedList<Integer> link = new LinkedList<>(hset);
        System.out.println("link "+link);
    }
    
}
