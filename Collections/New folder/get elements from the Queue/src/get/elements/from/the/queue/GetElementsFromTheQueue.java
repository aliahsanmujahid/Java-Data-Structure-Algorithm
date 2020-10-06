
package get.elements.from.the.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GetElementsFromTheQueue {

    public static void main(String[] args) {
       Queue<Integer> queue = new LinkedList<>();
        queue.add(200);
        queue.add(300);
        queue.add(400);
        queue.add(500);
        System.out.println(queue);
        
    }
    
}
