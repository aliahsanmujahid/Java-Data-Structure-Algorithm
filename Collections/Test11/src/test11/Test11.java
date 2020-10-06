
package test11;

import java.util.ArrayList;
import java.util.Vector;

public class Test11 {

    public static void main(String[] args) {
       ArrayList<String> ar = new ArrayList<>();
       ar.add("ratan");
       ar.add("anu");
       Vector<String> v = new Vector<String>(ar);
       v.add("poi");
       v.add("poipoi");
        System.out.println(v);
    }
    
}
