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
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 0 || n == 0)
            return 0;
        
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<n; j++)
            {
                int left = j-1 >= 0 ? j-1 : 0;
                int top = i-1 >= 0 ? i-1 : 0;
                if (i == 0 && j == 0)
                    continue;
                
                // add the left
                if (i == 0)
                {
                    grid[i][j] = grid[i][j] + grid[i][left];
                }
                // add top
                else if (j == 0)
                {
                    grid[i][j] = grid[i][j] + grid[top][j];
                }
                //take min of left and top
                else
                {
                    grid[i][j] = Math.min((grid[i][j] + grid[i][left]), (grid[i][j] + grid[top][j]));
                }
                
            }
        }
        
        return grid[m-1][n-1];
    }   
}
