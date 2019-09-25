package org.algoritham;

public class MaximumSizeSquare {

	public static void main(String[] args) {
		  int M[][] = {{0, 1, 1, 0, 1},  
                  {1, 1, 0, 1, 0},  
                  {0, 1, 1, 1, 0}, 
                  {1, 1, 1, 1, 0}, 
                  {1, 1, 1, 1, 1}, 
                  {0, 0, 0, 0, 0}}; 
            
      printMaxSubSquare(M);
	}


	private static void printMaxSubSquare(int[][] m) {

		int dp[][] =  new int[m.length][m[0].length];
		for (int i = 0; i < m[0].length; i++) {
			dp[0][i] = m[0][i];
		}
		
		for (int i = 0; i < m.length; i++) {
			dp[i][0] = m[i][0];
		}
		int result = 0;
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(m[i][j] > 0 ) {
					dp[i][j] = 1 +Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]); 
					if(dp[i][j]> result)
						result = dp[i][j];
				}
			}
		}
		
		System.out.println("size " + result);
		
	}

}
