package org.algoritham;

import java.util.Arrays;

public class ArraysAlgo {

	public static void main(String[] args) {

		int arr[] = new int[] { 1, 20, 6, 4, 5 }; 
		System.out.print("inversion count "+ inversionCount(arr));
		
		Arrays.stream(arr).forEach(System.out::println);
		
	}

	private static int inversionCount(int[] arr) {
		return inversionUsingMerge(arr, 0, arr.length -1);
	}

	private static int inversionUsingMerge(int[] arr, int left, int right) {
        int inver_count =0 ;
		if(left< right) {
			int mid = (left + right)/2;
			
			inver_count = inversionUsingMerge(arr, left, mid);
			inver_count += inversionUsingMerge(arr, mid+1, right);
			
			inver_count += merge(arr, mid, left, right);
		}
		
		return inver_count;
	}

	private static int merge(int[] arr, int mid, int low, int high) {

		int size1 = mid - low + 1;
		
		int size2 = high - mid;
		
		int inversion_count = 0;
		
		int[] L = new int[size1];
		
		int[] R =  new int[size2];
		
		for (int i = 0; i < size1; i++) {
			L[i] = arr[i+ low];
		}
		
		for (int j = 0; j < size2; j++) {
			R[j] = arr[j+ mid+1];
		}
		
		int i = 0 ,j =0, k=low;
		
		while (i< size1 
				&& j < size2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				inversion_count = inversion_count + (size2 - j);
				j++;
			}
			k++;
		}
		
		while(i < size1) {
			arr[k++] = L[i++];
			
		}
		
		while(j< size2) {
			arr[k++] = R[j++];
		}
	
		return inversion_count;
	}

}
