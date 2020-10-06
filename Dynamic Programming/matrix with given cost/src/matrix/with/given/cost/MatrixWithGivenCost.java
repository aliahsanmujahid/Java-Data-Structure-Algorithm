/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.with.given.cost;

/**
 *
 * @author Mujahid
 */
public class MatrixWithGivenCost {

    // Naive recursive top-down function to count total number of paths
    // to reach cell (m, n) from cell (0, 0) and having given cost
    public static int countPaths(int mat[][], int m, int n, int cost)
    {
        // base case
        if (cost < 0) {
            return 0;
        }
 
        // if we're at first cell (0, 0)
        if (m == 0 && n == 0) {
            return (mat[0][0] - cost == 0) ? 1: 0;
        }
 
        // if we're at first row, we can only go left
        if (m == 0) {
            return countPaths(mat, 0, n - 1, cost - mat[m][n]);
        }
 
        // if we're at first column, we can only go up
        if (n == 0) {
            return countPaths(mat, m - 1, 0, cost - mat[m][n]);
        }
 
        // recur to count total paths by going both left and top
        return countPaths(mat, m - 1, n, cost - mat[m][n]) +
                countPaths(mat, m, n - 1, cost - mat[m][n]);
    }
 
    // main function
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 4, 7, 1, 6 },
            { 5, 7, 3, 9 },
            { 3, 2, 1, 2 },
            { 7, 1, 6, 3 }
        };
 
        int cost = 25;
 
        System.out.println("Total paths with cost " + cost + " are " +
                countPaths(mat, mat.length-1, mat[0].length-1, cost));
    }
}
