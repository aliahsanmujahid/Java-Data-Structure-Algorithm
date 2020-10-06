package evaluate.given.postfix;
import java.util.Stack;

public class EvaluateGivenPostfix {
 
    public static int postfixEval(String exp){
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<exp.length();i++){
            if(Character.isDigit(exp.charAt(i))){
                stack.push(exp.charAt(i)-'0');
            }
            else{
                int x=stack.pop();
                int y=stack.pop();
                if(exp.charAt(i) == '+') {
                    stack.push(y + x);
                }
                else if(exp.charAt(i) == '-') {
                    stack.push(y - x);
                }
                else if(exp.charAt(i) == '*') {
                    stack.push(y * x);
                }
                else if(exp.charAt(i) == '/') {
                    stack.push(y / x);
                }
            }      
        }
    return stack.pop();
   }
    public static void main(String[] args){
        String exp = "138*+";
        System.out.println(postfixEval(exp));
    }
}
