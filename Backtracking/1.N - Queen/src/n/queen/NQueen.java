package n.queen;

import java.util.Arrays;

public class NQueen {
public static int N=4;

public static boolean isSafe(char mat[][],int r,int c){
     System.out.println("----> "+r+"||"+c);
    for (int i = 0; i < r; i++){
       System.out.println("U= "+i+"|"+c);
                  if (mat[i][c] =='Q')
                return false;
    }
 
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
        {
          System.out.println("\\="+i+"|"+j);
                        if (mat[i][j] == 'Q')
                return false;
        }
 
        for (int i = r, j = c; i >= 0 && j < N; i--, j++)
        {
         System.out.println("/="+i+"|"+j);
            if (mat[i][j] == 'Q')
                return false;
        }
    return true;
}
public static void nQueen(char mat[][],int r){
    if(r==N){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(mat[i][j]+" ");
            }
              System.out.println();
        }
        
             System.out.println();
            //  System.exit(0);
    }
    for(int i=0;i<N;i++){
        if(isSafe(mat,r,i)){
            mat[r][i]='Q';
            System.out.println("   Q---> "+r+":"+i);
            nQueen(mat,r+1);

            System.out.println(r+"::"+i);
            mat[r][i]='-';
            System.out.println("BackT= "+mat[r][i]+" "+r+" "+i); 
       }
    }

}
    public static void main(String[] args) {
      char[][] mat  = new char[N][N];
       for (int i=0;i<N;i++) 
            Arrays.fill(mat[i], '-');

     nQueen(mat,0);
   }
    
}
