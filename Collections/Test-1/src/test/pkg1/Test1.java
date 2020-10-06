
package test.pkg1;

import java.util.ArrayList;

class Emp{
  int eid;
String ename;
Emp(int x,String n){
    eid=x;
    ename=n;
}
}
class Student{
  int sid;
String sname;
Student(int x,String n){
    sid=x;
    sname=n;
}
}
public class Test1 {
    public static void main(String[] args) {
     ArrayList<Student> ar = new ArrayList<>();
    ar.add(new Student(111,"wewewe"));
    ar.add(new Student(222,"ererer"));
    for(Student e:ar)
        System.out.println(e.sid+" "+e.sname);
    
        Student e= ar.get(1);
        System.out.println(e.sid+" "+e.sname);
    }  
}
