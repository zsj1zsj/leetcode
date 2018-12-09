package algorithms;

public class UniquePaths {
	public int uniquePaths1(int m, int n) {
		int[][] dp = new int[m][n];

		// init first row
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}

		// init first column
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}

		return dp[m - 1][n - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int width = obstacleGrid[0].length;
		int[] dp = new int[width];
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j = 0; j < width; j++) {
				if (row[j] == 1)
					dp[j] = 0;
				else if (j > 0)
					dp[j] += dp[j - 1];
			}
		}
		return dp[width - 1];
	}

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;
				else {
					dp[i][j] = Math.min(i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE,
							j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE) + grid[i][j];
				}
			}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		int[][] obstacleGrid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		up.minPathSum(obstacleGrid);
	}
}
