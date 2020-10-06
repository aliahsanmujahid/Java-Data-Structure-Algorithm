
package queue.using.stack;
import java.util.Stack;
class Queue<T>{
    Stack<T> s1,s2;
    Queue(){
        s1=new Stack<>();
        s2 = new Stack<>();
    }
  public  void enqueue(T data){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(data);
        while(!s2.isEmpty()){
           s1.push(s2.pop());
        }
    }
    public T dequeue(){
        if(s1.isEmpty()){
            System.out.println("UnderFlow");
            System.exit(0);
        }
        return s1.pop();
    }
}
public class QueueUsingStack {
    public static void main(String[] args) {
    Queue p= new Queue();
    
    int keys[] = {1,2,3,4};
    for(int key:keys){
         p.enqueue(key);
    }
        System.out.println(p.dequeue());
         System.out.println(p.dequeue()); System.out.println(p.dequeue()); System.out.println(p.dequeue()); System.out.println(p.dequeue());
         
            
    }
            
    
}



