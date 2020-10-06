
package linklist2;

import java.util.LinkedList;
import java.util.ListIterator;

class Book{
    int id;
    String name,author;

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
public class LinkLIST2 {

    public static void main(String[] args) {
      LinkedList<Book> l = new LinkedList<>();
      l.add(new Book(111,"java","author"));
      l.add(new Book(222,"c","author"));
      l.add(new Book(333,"cpp","author"));
      
      ListIterator<Book> ll = l.listIterator();
      ll.add(new Book(444,"py","author"));
      while(ll.hasNext()){
                Book b = ll.next();
       // System.out.println(b.id +" "+b.name+" "+b.author);
        if(b.name.equals("c"))
            ll.remove();
      }
      for(Book b:l)
          System.out.println(b.id +" "+b.name+" "+b.author);
    }
    
}
