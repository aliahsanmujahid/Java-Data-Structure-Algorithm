
package path.in.a.maze;

public class PathInAMaze {
 /*    static int N;
     
  public static  void printSolution(int sol[][]) 
    { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + sol[i][j] + " "); 
            System.out.println(); 
        } 
    } 
     static boolean isSafe(int maze[][], int x, int y) 
    { 
         System.out.println("isSafe-- "+x+" "+y);
         if(( x < N && y < N && maze[x][y] == 1)){
             return true;
         }
        return false; 
    }
     public static boolean solveMaze(int maze[][],int x,int y,int sol[][]){
         System.out.println(x+" "+y);
         //printSolution(sol); 
         if (x == N - 1 && y == N - 1) { 
            sol[x][y] = 1; 
            return true; 
        }
         if (isSafe(maze, x, y) == true) { 
            System.out.println("safe-- "+x+" "+y);
            sol[x][y] = 1; 

            if (solveMaze(maze, x + 1, y, sol)) 
                return true; 
               System.out.println("x+1-- "+x+" "+y);

            if (solveMaze(maze, x, y + 1, sol)) 
                return true; 
               System.out.println("y+1-- "+x+" "+y);
            sol[x][y] = 0; 
            return false; 
        }else{
             System.out.println("Notsafe-- "+x+" "+y);
         } 
  
        return false; 
     }
    public static void main(String[] args) {
    int maze[][] = {
        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
                { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }
    };
    N=maze.length;
   int sol[][]=new int [N][N];
   if(solveMaze(maze,0,0,sol)){
        printSolution(sol); 
   }else{
        System.out.print("Solution doesn't exist"); 
   }
    } */
    
    
      static int M = 10;
      static  int N = 10;
 
    private static boolean isSafe(int mat[][], int visited[][], int x, int y)
    {
        return !(mat[x][y] == 0 || visited[x][y] != 0);
    }
    private static boolean isValid(int x, int y)
    {
        return (x < M && y < N && x >= 0 && y >= 0);
    }
     public static  void printSolution(int sol[][]) 
    { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + sol[i][j] + " "); 
            System.out.println(); 
        } 
    } 
    public static int findShortestPath(int mat[][], int visited[][],
                     int i, int j, int x, int y, int min_dist, int dist)
    {
     //   System.out.println(min_dist);
        // if destination is found, update min_dist
        if (i == x && j == y)
        {
           //  printSolution(visited);
         //System.exit(0);
           System.out.println(dist);
            
           return Integer.min(dist, min_dist);
           
        }
 
        // set (i, j) cell as visited
        visited[i][j] = 1;
 
        // go to bottom cell
        if (isValid(i + 1, j) && isSafe(mat, visited, i + 1, j)) {
            min_dist = findShortestPath(mat, visited, i + 1, j, x, y,
                                        min_dist, dist + 1);
        }
 
        // go to right cell
        if (isValid(i, j + 1) && isSafe(mat, visited, i, j + 1)) {
            min_dist = findShortestPath(mat, visited, i, j + 1, x, y,
                                        min_dist, dist + 1);
        }
 
        // go to top cell
        if (isValid(i - 1, j) && isSafe(mat, visited, i - 1, j)) {
            min_dist = findShortestPath(mat, visited, i - 1, j, x, y,
                                        min_dist, dist + 1);
        }
 
        // go to left cell
        if (isValid(i, j - 1) && isSafe(mat, visited, i, j - 1)) {
            min_dist = findShortestPath(mat, visited, i, j - 1, x, y,
                                        min_dist, dist + 1);
        }
 
        // Backtrack - Remove (i, j) from visited matrix
        visited[i][j] = 0;
 
        return min_dist;
    }
     public static void main(String[] args)
    {
        int mat[][] =
        {
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
        };
 
        // construct a matrix to keep track of visited cells
        int[][] visited = new int[M][N];
 
        int min_dist = findShortestPath(mat, visited, 0, 0, 7, 5,
                                        Integer.MAX_VALUE, 0);
 
        if(min_dist != Integer.MAX_VALUE) {
            System.out.println("The shortest path from source to destination "
                              + "has length " + min_dist);
        }
        else {
            System.out.println("Destination can't be reached from source");
        }
    }
}
