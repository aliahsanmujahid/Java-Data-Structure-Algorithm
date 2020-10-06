package duplicate.parenthesis;
import java.util.Stack;
public class DuplicateParenthesis {

public static boolean duplicateparenthesis(String exp){
         Stack<Character> stack = new Stack();
         for(int i=0;i<exp.length();i++){
             if (exp.charAt(i) != ')') {
                stack.push(exp.charAt(i));
            }else{
                 if(stack.peek()=='('){
                     return true;
                 }
                 while(stack.peek()!='('){
                     stack.pop();
                 }
                 stack.pop();  
             }
         }
         return false;
    }
 public static void main(String[] args){
            String exp= "((x+y))";
            if(duplicateparenthesis(exp)){
                System.out.println("The expression have duplicate parenthesis."); 
            }
            else{
                System.out.println("The expression does not have duplicate " +
                                "parenthesis");
       }
      }  
}
