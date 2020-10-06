package generics;

public class Generics {
    public<E>void printArray(E[] s){
        for (int i=0;i<s.length;i++) {
            System.out.print(s[i]+" ");
        }
        System.out.println("\n");
    }

    
    public static void main(String[] args) {
        Generics gn=new Generics();
        String[] s1 = new String[]{"wewe","rt"};
        Integer number[]=new Integer[]{1,2,3,4,5};
        gn.printArray(s1);
        gn.printArray(number);
    }
    
}
