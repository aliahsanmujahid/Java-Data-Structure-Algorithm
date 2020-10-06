
package pkg8.find.maximum.minimum;

public class FindMaximumMinimum {

    public static int maximum(int a,int b,int c){
    int min = 0;
    while (a>0 || b>0|| c>0){
        a--; b--;c--;min++;
    }
    return min;
}
      public static int minimum(int a,int b,int c){
    int min = 0;
    while (a>0 && b>0&& c>0){
        a--; b--;c--;min++;
    }
    return min;
}
    public static void main(String[] args) {
        System.out.println("Max: "+maximum(7,9,4));
        System.out.println("Max: "+minimum(7,9,4));
    }
    
}
