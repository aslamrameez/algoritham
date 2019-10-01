package org.algoritham;

public class DutchNationalFlag {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		sort012(arr, arr.length);
		printArray(arr, arr.length);
	}

	private static void sort012(int[] arr, int arr_size) {
		int mid = 0, low = 0, high = arr_size - 1;

		while (mid <= high) {
			switch (arr[mid]) {
			case 0: {
				swap(arr, low, mid);
				mid++;
				low++;
				break;
			}
			case 1: {
				mid++;
				break;
			}
			case 2: {
				swap(arr, mid, high);
				high--;
				break;
			}
			}
		}
	}

	static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

	static void printArray(int arr[], int arr_size) {
		int i;
		for (i = 0; i < arr_size; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}
}
