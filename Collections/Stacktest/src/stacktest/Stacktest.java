
package stacktest;

import java.util.Stack;

public class Stacktest {

    public static void main(String[] args) {
       Stack<String> s = new Stack<>();
       s.push("poioi");
       s.push("iopiop");
       s.push("plpl");
        System.out.println(s);
       s.pop();
        System.out.println(s);
        System.out.println(s.search("poioi"));
        s.clear();
        System.out.println(s.empty());
    }
    
}
