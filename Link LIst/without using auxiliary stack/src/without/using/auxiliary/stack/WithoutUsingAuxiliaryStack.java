package without.using.auxiliary.stack;
import java.util.Stack;

public class WithoutUsingAuxiliaryStack {
private Stack<Integer> s=new Stack<>();
    private int min;
    public void push(int x){
        if(s.empty()){
            s.push(x);
            min=x;
        }
        else if(x>min){
            s.push(x);
        }
        else{
            s.push(2*x-min);
            min=x;
        }
    }
    public void pop(){
        if(s.empty()){
            System.out.println("Stack Overflow");
        }
        int top = s.peek();
        if(top<min){
            min=2*min-top;
        }
        s.pop();
    }
    public int min(){
        return min;
    }
    public static void main(String[] args){
        WithoutUsingAuxiliaryStack s= new WithoutUsingAuxiliaryStack();
        s.push(6);
        System.out.println(s.min());
 
        s.push(7);
        System.out.println(s.min());
 
        s.push(5);
        System.out.println(s.min());
 
        s.push(3);
        System.out.println(s.min());
 
        s.pop();
        System.out.println(s.min());
 
        s.pop();
        System.out.println(s.min());
        
    }
}
