
package test.pkg4;

import java.util.ArrayList;
import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
     String[] s = {"erre","vsdfv","wewe"};
     ArrayList<String> a1 = new ArrayList<>(Arrays.asList(s));
     a1.add("vefvsd");
     a1.add("xjncf");
        System.out.println(a1);
        
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("ratan");
        a2.add("poioi");
        String [] s1 = new String[a2.size()];
        a2.toArray(s1);
        for(String ss:s1)
            System.out.println(ss);
        
        ArrayList a3 = new ArrayList(); 
        a3.add("DFVDfv");
        a3.add(10);
        Object[]  o = a3.toArray();
        for(Object oo:o)
            System.out.println(oo);
        
    }
}
