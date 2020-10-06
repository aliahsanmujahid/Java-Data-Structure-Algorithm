package knight.s.tours;

public class KnightSTours {

    public static int N=5;
    
    static int row[] = {2, 1, -1, -2, -2, -1,  1,  2 , 2 };
    static int col[] = {1, 2,  2,  1, -1, -2, -2, -1, 1 };
    
    public static boolean isValid(int x,int y){
        System.out.println("isValid-- "+x+" "+y);
        if(x<0||y<0||x>=N||y>=N){
            System.out.println("Invalid");
                    
            return false;
        }
              System.out.println("Valid");
        return true;
    }
    private static void print(int[][] visited)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void knightTour(int visited[][], int x, int y, int pos ){
        visited[x][y] = pos;
        System.out.println("Visited-- "+visited[x][y]+" x-y ["+x+" "+y+"] Pos= "+pos);
        if(pos >= N*N){
            print(visited);
          //  visited[x][y] = 0;
            System.out.println("BackT-visited-- "+visited[x][y]+" "+x+" "+y);
            //return;
            System.exit(0);
        }
        for(int k=0;k<8;k++){
            System.out.println("k= "+k+" ");
            int newX=x+row[k];
            int newY=y+col[k];
            System.out.println("nextMove-- "+newX+" "+newY);
            if (isValid(newX, newY) && visited[newX][newY] == 0){
                 knightTour(visited, newX, newY, pos + 1);
            }
        }
         System.out.println("   BaccTrack-- "+visited[x][y]+" "+x+" "+y);
         visited[x][y] = 0;
    }
    public static void main(String[] args) {
        int visited[][] = new int [N][N];
        int pos=1;
         knightTour(visited, 0, 0, pos);
    }
            
}
