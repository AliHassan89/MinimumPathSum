/*

Given a m x n grid filled with non-negative numbers, find a path from top left 
to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.

 */
package minimumpathsum;

/**
 *
 * @author ali_hassan_syed
 */
public class MinimumPathSum 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
    }
 
    public int minPathSum(int[][] grid) 
    {
        return minCost(grid, grid.length, grid[0].length);
    }
 
    private static int minCost(int cost[][], int m, int n)
    {
        int i, j;
        int memo[][] = new int[m+1][n+1];
 
        memo[0][0] = cost[0][0];
 
        /* Initialize first column of total cost(memo) array */
        for (i = 1; i <= m; i++)
            memo[i][0] = memo[i-1][0] + cost[i][0];
 
        /* Initialize first row of memo array */
        for (j = 1; j <= n; j++)
            memo[0][j] = memo[0][j-1] + cost[0][j];
 
        /* Construct rest of the memo array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                memo[i][j] = min(memo[i-1][j],
                               memo[i][j-1]) + cost[i][j];
 
        return memo[m][n];
    }
}
