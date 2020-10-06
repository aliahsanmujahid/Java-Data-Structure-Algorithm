package decode.the.given.sequence;
import java.util.Stack;
public class DecodeTheGivenSequence {
    public static StringBuilder decode(String seq){
        StringBuilder result = new StringBuilder();
        
        Stack<Integer>stack = new Stack<>();
        
        for(int i = 0; i <= seq.length(); i++){
            stack.push(i+1);
            if (i == seq.length() || seq.charAt(i) == 'I')
            {
                while (!stack.empty())
                {
                    result.append(stack.pop());
                }
            }        
        }
return result;
}
    public static void main(String[] args)
    {
        String seq = "IDIDII";
        System.out.println("Minimum number is " + decode(seq));
    }
    
}
