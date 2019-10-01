package org.algoritham;

import java.util.Arrays;

public class MaxMinAlgo {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6 };
		rearrange(arr, arr.length);
	}

	static void rearrange(int[] arr, int n) {

		int temp[] = new int[n];
		int low = 0, high = n - 1;
		boolean flag = true;
		
		for (int j = 0; j < n; j++) {
			if (flag) {
				temp[j] = arr[high--];
			} else {
				temp[j] = arr[low++];
			}
			flag = !flag;
		}
	System.out.println(	Arrays.toString(temp));
	}

}
