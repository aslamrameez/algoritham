package org.algoritham;

import java.util.Arrays;

public class LongestIncreasingSubseq {

	public static void main(String[] args) {
		int arr[] = { 5, 1, 3, 6, 8, 2, 9, 0, 10 };
		System.out.println(longeestIncreasingSeqLength(arr));
		System.out.println(longeestIncreasingSeqLengthNlogN(arr));
	}

	private static int longeestIncreasingSeqLength(int[] arr) {

		int[] seqSize = new int[arr.length];

		for (int i = 0; i < seqSize.length; i++) {
			seqSize[i] = 1;
		}
		int maxlenght = 1;
		for (int i = 1; i < seqSize.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && seqSize[j] < seqSize[i] + 1) {
					seqSize[i] = seqSize[j] + 1;
					if (seqSize[i] > maxlenght)
						maxlenght = seqSize[i];
				}
			}

		}

		return maxlenght;
	}

	private static int longeestIncreasingSeqLengthNlogN(int[] arr) {

		int result[] = new int[arr.length];
		int temp[] = new int[arr.length];

		int lenght = 1;

		Arrays.fill(result, -1);

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[temp[0]]) {
				temp[0] = i;
			} else if (arr[temp[lenght - 1]] < arr[i]) {
				result[i] = temp[lenght - 1];
				temp[lenght++] = i;
			} else {
				int pos = getCeilIndex(arr, temp, -1,  lenght - 1, arr[i]);

				result[i] = temp[pos - 1];
				temp[pos] = i;
			}

		}
		
		  for (int i = temp[lenght - 1]; i >= 0; 
		             i = result[i]) 
		            System.out.print(arr[i] + " "); 
		return lenght;
	}

	static int getCeilIndex(int arr[], int T[], int l, int r, int key) {

		while (r - l > 1) {

			int m = l + (r - l) / 2;
			if (arr[T[m]] >= key)
				r = m;
			else
				l = m;
		}

		return r;
	}

}
