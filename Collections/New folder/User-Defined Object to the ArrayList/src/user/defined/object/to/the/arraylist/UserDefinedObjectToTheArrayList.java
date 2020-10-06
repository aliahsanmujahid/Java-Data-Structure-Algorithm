
package user.defined.object.to.the.arraylist;

import java.util.ArrayList;
import java.util.List;

class Employee{
    String name;
    int age;
    int sallery;

    public Employee(String name, int age, int sallery) {
        this.name = name;
        this.age = age;
        this.sallery = sallery;
    }
    public void setname(String n){
        name=n;
    }
        public void setage(int n){
        age=n;
    }
            public void setsallery(int n){
        sallery=n;
    }
                public String getname(){
        return name;
    }
                    public int getage(){
        return age;
    }
                        public int getsallery(){
        return sallery;
    }
   @Override
   public String toString(){
       return "Emplyee [ name="+name+", age="+age+" Sallery="+sallery+" ]";
   }
}
public class UserDefinedObjectToTheArrayList {

    public static void main(String[] args) {
    List<Employee> list  = new ArrayList<>();
    Employee john = new Employee("john",23,3434);
    Employee david = new Employee("david",13,3434);
    Employee peter = new Employee("peter",24,3434);
    
    list.add(john);
    list.add(david);
    list.add(peter);
    for(Employee e:list){
        System.out.println(e);
    }
    
    /*    ListIterator<Employee> itr = list.listIterator();
    while(itr.hasNext()){
        Employee e = itr.next();
        System.out.println("Emplyee [ name="+e.name+", age="+e.age+" Sallery="+e.sallery+" ]");
                
    }*/
    }
    
}
