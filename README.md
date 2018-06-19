# MinimumPathSum


Given a m x n grid filled with non-negative numbers, find a path from top left 
to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.

Solution:

1. A 2D integer array is received as function parameter. Each value in 2D array represent an int value of cost. The task is to calculate minimum cost it takes to get from matrix[0][0] to matrix[m][n] where m is number of rows in matrix and n is number of columns.

2. We pass matrix, m and n in a helper function.

3. We will be using dynamic programming so we will create a memo matrix of one extra row and an extra column because the final cost of traversal will be stored in memo[m][n].

4. Initialize memo[0][0] with matrix[0][0]

5. Initialize first row of memo array, thats because the first row can only be accessed from previous block </br>
        for (j = 1; j <= n; j++)</br>
            memo[0][j] = memo[0][j-1] + cost[0][j];</br>
			
6. Initialize first column of memo array, thats because the first column can only be accessed from upper block </br>
for (i = 1; i <= m; i++)</br>
            memo[i][0] = memo[i-1][0] + cost[i][0];</br>
			
7. Construct rest of the memo array 
	* starting loop from 1st index going up to m. 
	* starting second nested loop from 1st index going up to n.
	* It then takes minimum of upper and left block and adds the value of that block to minimum value and stores it in memo[i][j]
	
8. Lastly memo[m][n] is returned.
