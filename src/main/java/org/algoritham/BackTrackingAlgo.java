package org.algoritham;

public class BackTrackingAlgo {

	public static void main(String[] args) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

		solveMaze(maze);
	}

	private static boolean solveMaze(int[][] maze) {
		int N = maze.length;
		int sol[][] = new int[N][N];

		if (solveMazeUtil(maze, 0, 0, N, sol) == false) {
			System.out.print("Solution doesn't exist");
			return false;
		}

		printSolution(sol);
		return true;
	}

	private static void printSolution(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++)
				System.out.print(" " + sol[i][j] + " ");
			System.out.println();
		}
	}

	static boolean isSafe(int maze[][], int x, int y, int N) {
		return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
	}

	private static boolean solveMazeUtil(int[][] maze, int x, int y, int N, int[][] sol) {

		if (x == N - 1 && y == N - 1) {
			sol[x][y] = 1;
			return true;
		}
		
		 if (isSafe(maze, x, y, N) == true) { 
			 sol[x][y] = 1; 
			 
			 if (solveMazeUtil(maze, x + 1, y, N, sol)) 
	                return true; 
			 
			 if (solveMazeUtil(maze, x, y + 1, N, sol)) 
	                return true; 
			 
			 sol[x][y] = 0; 
	         return false; 
		 }

		return false;
	}

}
