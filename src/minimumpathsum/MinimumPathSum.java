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
    public int minPathSum(int[][] grid) {
        Map<String, Integer> memo = new HashMap<>();
        return minPathSum(grid, 0, 0, memo);
    }
    
    private int minPathSum(int[][] grid, int x, int y, Map<String, Integer> memo)
    {
        if (x >= grid.length || y >= grid[0].length)
            return Integer.MAX_VALUE;
        String key = x + "," + y;
        if (memo.get(key) != null)
        {
            return memo.get(key);
        }
        if (x == grid.length-1 && y == grid[0].length -1)
        {
            memo.put(key, grid[x][y]);
            return memo.get(key);
        }
        memo.put(key, grid[x][y] + Math.min(minPathSum(grid, x+1, y, memo), minPathSum(grid, x, y+1, memo)));
        return memo.get(key);
    }
}
