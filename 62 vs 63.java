 //62 vs 63s
class Solution{
	public int uniquePaths(int m, int n){
		//to every point how many ways to go
		//初始化先找边界值
		//并且每次都只能往下或者往上
		int[][] dp = new int[m][n];

		//第一行第一列初始化都是1
		for(int i=0; i<m; i++){
			dp[i][0] = 1;
		}
		for(int j=0; j<n; j++){
			dp[0][j] = 1;
		}

		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}

		return dp[m-1][n-1];

	}
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //初始化不同在第一行第一列如果遇到了障碍 后面的全都是0 
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i=0; i<obstacleGrid.length; i++){
        	if(obstacleGrid[i][0] == 1) break;
        	dp[i][0] = 1;
        }

        for(int j=0; j<obstacleGrid[0].length; j++){
        	if(obstacleGrid[0][j] == 1) break;
        	dp[0][j] = 1;
        }

        for(int i=1; i<obstacleGrid.length; i++){
        	for(int j=1; j<obstacleGrid[0].length; j++){
        		if(obstacleGrid[i][j] == 1) continue;
        		dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }

        return dp[m-1][n-1];
    }
}