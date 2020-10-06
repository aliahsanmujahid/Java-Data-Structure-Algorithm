
package total.unique.paths.in.a.maze;
/*
 static int N;
     
  public static  void printSolution(int sol[][]) 
    { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + sol[i][j] + " "); 
            System.out.println(); 
        } 
    } 
    private static boolean isSafe(int mat[][], int visited[][], int x, int y)
    {
        return !(mat[x][y] == 0 || visited[x][y] != 0);
    }
    private static boolean isValid(int x, int y)
    {
        return (x < N && y < N && x >= 0 && y >= 0);
    }
     public static void solveMaze(int maze[][],int i,int j,int visited[][]){
       
         if (i ==  N - 1 && j ==   N - 1) { 
             visited[i][j] = 1;
            printSolution(visited); 
             System.out.println("------------------");
            // System.exit(0);
        }
          visited[i][j] = 1;
         if (isValid(i + 1, j) && isSafe(maze, visited, i + 1, j))
            solveMaze(maze, i + 1, j ,visited );
 
        // go to right cell
        if (isValid(i, j + 1) && isSafe(maze, visited, i, j + 1)) {
           solveMaze(maze, i, j + 1 ,visited);
        }
 
        // go to top cell
        if (isValid(i - 1, j) && isSafe(maze, visited, i - 1, j)) {
           solveMaze(maze, i-1, j  ,visited);
        }
 
        // go to left cell
        if (isValid(i, j - 1) && isSafe(maze, visited, i, j - 1)) {
          solveMaze(maze, i, j -1 ,visited);
        }
         visited[i][j] = 0;
     }
    public static void main(String[] args) {
    int maze[][] = {
                          { 1, 1, 1, 1 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 1 },
            { 1, 1, 1, 1 }
    };
    N=maze.length;
   int sol[][]=new int [N][N];
  solveMaze(maze,0,0,sol);
     
    } 


*/
public class TotalUniquePathsInAMaze {
    
    static int N=4;
    private static boolean isValidCell(int x, int y)
    {
        if (x < 0 || y < 0 || x >= N || y >= N)
            return false;
 
        return true;
    }
    public static  void printSolution(int sol[][]) 
    { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + sol[i][j] + " "); 
            System.out.println(); 
        } 
    } 
    public static int countPaths(int maze[][], int x, int y,
                                  int visited[][], int count) {
        
        if (x == N - 1 && y == N - 1)
        {
            count++;
          visited[x][y] = 1;
            printSolution(visited);
            System.out.println("444444");
            return count;
        }
        
        visited[x][y] = 1;
        
        if (isValidCell(x, y) && maze[x][y] == 1){
            
             // go down (x, y) --> (x + 1, y)
            if (x + 1 < N && visited[x + 1][y]==0)
                count = countPaths(maze, x + 1, y, visited, count);
 
            // go up (x, y) --> (x - 1, y)
            if (x - 1 >= 0 && visited[x - 1][y]==0)
                count = countPaths(maze, x - 1, y, visited, count);
 
            // go right (x, y) --> (x, y + 1)
            if (y + 1 < N && visited[x][y + 1]==0)
                count = countPaths(maze, x, y + 1, visited, count);
 
            // go left (x, y) --> (x, y - 1)
            if (y - 1 >= 0 && visited[x][y - 1]==0)
                count = countPaths(maze, x, y - 1, visited, count);
        }
        
         visited[x][y] = 0;
        
        
        return count;
    }
    public static void main(String[] args) {
         int maze[][] =
        {
            { 1, 1, 1, 1 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 1 },
            { 1, 1, 1, 1 }
        };
         
         
         int count=0;
          int[][] visited = new int[N][N];
          
          count = countPaths(maze,0,0,visited,count);
          
           System.out.println("Total number of unique paths are " + count);
    }
}
 

