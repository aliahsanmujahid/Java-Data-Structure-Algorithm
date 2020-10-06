
package test9;

import java.util.ArrayList;
import java.util.Iterator;

class Book{
    int id;
    String name;
    String author;

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    
}
public class Test9 {

    public static void main(String[] args) {
        ArrayList<Book> books =new  ArrayList(); 
        books.add(new Book(111,"java","ewce"));
        books.add(new Book(222,"c","ewce"));
        books.add(new Book(333,"cpp","ewce"));
        
        Iterator<Book> itr = books.iterator();
        while(itr.hasNext()){
        Book b = itr.next();
        if(b.id==111)
            itr.remove();
        if(b.name.equals("cpp"))
            itr.remove();
    }
    for(Book b:books)
        System.out.println(b.id+" "+b.name+" "+b.author);
    
}}
