
package test.pkg3;

import java.util.ArrayList;

class Emp{
  int eid;
String ename;
Emp(int x,String n){
    eid=x;
    ename=n;
}
}
public class Test3 {

    public static void main(String[] args) {
       Emp e1 = new Emp(111,"rathan");
       Emp e2 = new Emp(222,"qwqw");
       Emp e3 = new Emp(333,"tyty");
       Emp e4 = new Emp(444,"fgbnxbv");
       
       ArrayList<Emp> a1 = new ArrayList<>();
       a1.add(e1);
       a1.add(e2);
       ArrayList<Emp> a2 = new ArrayList<>();
       a2.addAll(a1);
       a2.add(e3);
       a2.add(e4);
       
       for(Emp e:a2)
           System.out.println(e.eid+" "+e.ename);
    }
    
}
