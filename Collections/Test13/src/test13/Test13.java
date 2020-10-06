
package test13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

class Product{
    int id;
    String name;
    int cost;

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
    
}
public class Test13 {

    public static void main(String[] args) {
      Vector <Product> products = new Vector<>();
      products.add(new Product(111,"pen",20));
      products.add(new Product(222,"fan",300));
       products.add(new Product(333,"light",200));
       
       Enumeration<Product> e = products.elements();
       while(e.hasMoreElements()){
           Product p = e.nextElement();
           System.out.println(p.id+" "+p.name+" "+p.cost);
       }
              Iterator<Product> itr = products.iterator();
       while(itr.hasNext()){
           Product p = itr.next();
           System.out.println(p.id+" "+p.name+" "+p.cost);
       }
                       ListIterator<Product> Litr = products.listIterator();
       while(Litr.hasNext()){
           Product p = Litr.next();
           System.out.println(p.id+" "+p.name+" "+p.cost);
       }  
    }
    
}
