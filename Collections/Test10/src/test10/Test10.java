
package test10;

import java.util.ArrayList;
import java.util.ListIterator;

public class Test10 {

    public static void main(String[] args) {
      ArrayList<String> ar =new  ArrayList(); 
        ar.add("rahim");
        ar.add("poipio");
        ar.add("iopiop");
        
        ListIterator<String> itr = ar.listIterator();
        while(itr.hasNext()){
        String s = itr.next();
        if(s.equals("poipio"))
            itr.remove();
        if(s.equals("iopiop"))
            itr.set("Karim");
    }
        System.out.println(ar);
    
    }
    
}
