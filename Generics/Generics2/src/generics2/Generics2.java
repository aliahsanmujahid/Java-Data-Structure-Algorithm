package generics2;

class mydata<T>{
    T i;
    public void add(T i1){
        i=i1;
    }
    public T get(){
        return i;
    }    
        public void printArray(T s){
        for (int i=0;i<1;i++) {
            System.out.print(s+" ");
        }
        System.out.println("\n");
    }
}
public class Generics2 {

    public static void main(String[] args) {
      mydata my= new mydata();
      mydata my2= new mydata();
      String [] a= new String[]{"sefw","Wef"};
            my.printArray(a[1]);
      my.add(1);
        System.out.println(my.get());
        my2.add("qwqw");
        System.out.println(my2.get());
    }
    
}
