
package test12;

import java.util.Iterator;
import java.util.Vector;

public class Test12 {

    public static void main(String[] args) {
      Vector <Integer> v =new Vector<>();
      for(int i=1;i<=30;i++)
        v.add(i);
        System.out.println(v);
        Iterator<Integer> itr = v.iterator();
        while(itr.hasNext()){
           Integer i = itr.next();
           if(i%2==0)
                System.out.print(i+"->");
           else
                itr.remove();
        }
        System.out.println();
        System.out.print(v);
            
    }
    
}
