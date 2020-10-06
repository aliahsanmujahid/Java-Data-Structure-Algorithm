
package get.each.object.from.the.linkedlist;

import java.util.HashSet;
import java.util.LinkedList;

public class GetEachObjectFromTheLinkedList {

    public static void main(String[] args) {
                  HashSet<Integer> hset = new HashSet<>();
      hset.add(100);
       hset.add(200);
        hset.add(300);
       

        for(int s :hset){
            System.out.println(s); 
       }
    }
    
}
