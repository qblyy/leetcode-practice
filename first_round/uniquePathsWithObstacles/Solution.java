package uniquePathsWithObstacles;

public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0
        || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = (obstacleGrid[i-1][j] == 1 ? 0 : dp[i-1][j])
                    + (obstacleGrid[i][j-1] == 1 ? 0 : dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
    
    public static void main(String... args) {
		int[][] obstacleGrid = {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};
		int result = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(result);
    }
}
