package queue.implement;
public class QueueImplement {

    int front=0;
    int rear=-1;
    int capacity;
    int count=0;
    int[] arr;
    QueueImplement(int data){
        this.capacity=data;
        this.arr=new int [data];
    }
    
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full"); 
        }else{
            System.out.println("Adding "+data);
            rear=(rear+1)%capacity;
            arr[rear]=data;
            count++;
        }
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty"); 
        }else{
            System.out.println("Removing "+arr[front]);  
            front=(front+1)%capacity;
            count--;
        }
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }

            return arr[front];
        
    }
    public int size(){
        return count;
    }
    public Boolean isFull(){
        return size()==capacity;
    }
   public Boolean isEmpty(){
        return size()==0 ;
    }
    public static void main(String[] args) {
        QueueImplement q= new QueueImplement(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.peek());                
        q.dequeue();
        System.out.println(q.peek());    
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }
    
            
}

