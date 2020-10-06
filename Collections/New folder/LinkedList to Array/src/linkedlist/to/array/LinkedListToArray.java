
package linkedlist.to.array;

import java.util.LinkedList;

public class LinkedListToArray {

    public static void main(String[] args) {
    LinkedList<Integer> linkedlist = new LinkedList<>();
    linkedlist.add(200);
    linkedlist.add(300);
    linkedlist.add(400);
    linkedlist.add(500);
        System.out.println(linkedlist);
        
        /*Integer[] inAr  = new Integer[linkedlist.size()];
        linkedlist.toArray(inAr);   
        for(Integer a:inAr){
            System.out.println(a);
        }*/
        Object[] toArray =  linkedlist.toArray();   
          for(Object a:toArray){
            Integer value  = (Integer) a;
            System.out.println(a);
        }
    }
    
}
