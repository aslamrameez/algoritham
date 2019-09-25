package org.algoritham;

public class MaximumSumRectangle {

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 8, 6, 7, 3 }, { 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 5 } };

		int k = 3;

		System.out.println("Maximum sum 3 x 3 matrix is");
		printMaxSumSub(mat, k);
		// int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int a[] = { 4, -3, 2, 1, 2, -1, -2, -3 };
		int n = a.length;
		kadaneAlgoritam(a, n);

		findMaxSubMatrix(
				new int[][] { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } });
	}

	private static void findMaxSubMatrix(int[][] a) {
		int cols = a[0].length;
		int rows = a.length;
		int[] currentResult;
		int maxSum = Integer.MIN_VALUE;
		int left = 0;
		int top = 0;
		int right = 0;
		int bottom = 0;

		for (int leftCol = 0; leftCol < cols; leftCol++) {
			int[] tmp = new int[rows];

			for (int rightCol = leftCol; rightCol < cols; rightCol++) {
				for (int i = 0; i < rows; i++) {
					tmp[i] += a[i][rightCol];
				}
				currentResult = kadane(tmp);
				if (currentResult[0] > maxSum) {
					maxSum = currentResult[0];
					left = leftCol;
					right = rightCol;
					top = currentResult[1];
					bottom = currentResult[2];
				}
			}
		}

		System.out
				.println("MaxSum: " + maxSum + ", range: [(" + left + ", " + top + ")(" + right + ", " + bottom + ")]");
	}

	static int[] kadane(int a[]) {
		int[] result = new int[] { Integer.MIN_VALUE, 0, -1 };
		int currentSum = 0;
		int localStart = 0;
		for (int i = 0; i < a.length; i++) {
			currentSum += a[i];
			if (currentSum < 0) {
				currentSum = 0;
				localStart = i + 1;
			} else if (result[0] < currentSum) {
				result[0] = currentSum;
				result[1] = localStart;
				result[2] = i;
			}
		}

		if (result[2] == -1) {
			result[0] = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] > result[0]) {
					result[0] = a[i];
					result[1] = i;
					result[2] = i;
				}
			}
		}

		return result;
	}

	static void kadaneAlgoritam(int a[], int size) {
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0, start = 0, end = 0, s = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here += a[i];

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}
			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}

		}

		System.out.println("Maximum contiguous sum is " + max_so_far);
		System.out.println("Starting index " + start);
		System.out.println("Ending index " + end);

	}

	private static void printMaxSumSub(int[][] mat, int k) {
		int N = mat.length;
		if (k > N)
			return;

		// To store sums of all strips of size k x 1
		int[][] stripSum = new int[N][N];

		for (int j = 0; j < N; j++) {

			// Calculate sum of first k x 1 rectangle
			// in this column
			int sum = 0;
			for (int i = 0; i < k; i++)
				sum += mat[i][j];

			stripSum[0][j] = sum;
			// Calculate sum of remaining rectangles
			for (int i = 1; i < N - k + 1; i++) {
				sum += (mat[i + k - 1][j] - mat[i - 1][j]);
				stripSum[i][j] = sum;
			}

		}

		int max_sum = Integer.MIN_VALUE;
		Position pos = new Position(-1, -1);
		// 2: CALCULATE SUM of Sub-Squares using stripSum[][]
		for (int i = 0; i < N - k + 1; i++) {

			// Calculate and print sum of first subsquare
			// in this row
			int sum = 0;
			for (int j = 0; j < k; j++)
				sum += stripSum[i][j];

			// Update max_sum and position of result
			if (sum > max_sum) {
				max_sum = sum;
				pos.updatePosition(i, 0);
			}

			// Calculate sum of remaining squares in
			// current row by removing the leftmost
			// strip of previous sub-square and adding
			// a new strip
			for (int j = 1; j < N - k + 1; j++) {
				sum += (stripSum[i][j + k - 1] - stripSum[i][j - 1]);

				// Update max_sum and position of result
				if (sum > max_sum) {
					max_sum = sum;
					pos.updatePosition(i, j);
				}
			}
		}

		// Print the result matrix
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				System.out.print(mat[i + pos.getXPosition()][j + pos.getYPosition()] + " ");
			}
			System.out.println();
		}

	}
}

class Position {
	int x;
	int y;

	// Constructor
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Updates the position if new maximum sum
	// is found
	void updatePosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// returns the current value of X
	int getXPosition() {
		return this.x;
	}

	// returns the current value of y
	int getYPosition() {
		return this.y;
	}
}
