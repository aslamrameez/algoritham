package org.algoritham;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class SortAlgoritham {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 1, 6, 7, 4, 2 };
		
		MergeSort task =  new MergeSort(arr, 0, arr.length -1);
		
		//task.sort(arr, 0, arr.length -1);
		ForkJoinPool pool=new ForkJoinPool();
		pool.invoke(task);
		
		Arrays.stream(task.arr).forEach(System.out::print);
	}

	static class MergeSort extends RecursiveAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int low;
		int high;
		int arr[];

		MergeSort(int[] arr, int low, int high) {
			this.low = low;
			this.high = high;
			this.arr = arr;
		}
		

		@Override
		protected void compute() {
			if (low < high) {
				 int mid = (low+high)/2;
				 
				 MergeSort task1  = new  MergeSort(arr, low, mid);
				 
				 MergeSort task2  = new  MergeSort(arr, mid+1, high);
				 
				 invokeAll(task1, task2);
				 
				 merge(arr, low, mid, high);
				 
			}
		}
		
		public void sort(int[] arr, int low, int high) {
			if (low < high) {
				 int mid = (low+high)/2;
				 sort(arr, low, mid);
				 sort(arr, mid+1, high);
				 merge(arr, low, mid, high);
			}
		}

		private void merge(int[] arr, int low, int mid, int high) {
			
			int size1 = mid - low + 1;
			
			int size2 = high - mid;
			
			int L[]  = new int[size1];
			int R[] = new int[size2];
			
			for (int i=0; i<size1; ++i)
                L[i] = arr[low + i];
            
			for (int j=0; j< size2; ++j)
                R[j] = arr[mid +  j + 1];
			
			int i = 0, j = 0;
			
			int k = low;
			 while (i < size1 && j < size2)
             {
				 if(L[i] <= R[j]) {
					 arr[k] =  L[i];
					 i++;
				 }else {
					 arr[k] =  R[j];
					 j++;
				 }	
				 k++;
             }
			 
			  while (i < size1)
              {
                  arr[k] = L[i];
                  i++;
                  k++;
              }
			  
			  while (j < size2)
              {
                  arr[k] = R[j];
                  j++;
                  k++;
              }
		}

	}

}
