package arraylist.constructors;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListConstructors {

    public static void main(String[] args) {
      HashSet<String> hashset = new HashSet<String>();
      hashset.add("Ram");
       hashset.add("Dave");
        hashset.add("Rohit");
        System.out.println("Hashset : "+hashset);
        
        ArrayList<String> ar = new ArrayList<>(hashset);
        System.out.println("ArrayList: "+ar); 
               
    }
    
}
