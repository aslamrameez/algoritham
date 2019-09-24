package org.algoritham;


import java.util.Arrays;
import java.util.PriorityQueue;


public class NthLargestElement {

	public static void main(String[] args) {
		
		int[] arr = new int[] {3,2,1,5,6,4};
		System.out.println(findKthLargest(arr, 3));
		System.out.println(findKthLargestHeap(arr, 3));
	}

	private static int findKthLargest(int[] arr, int i) {
		PriorityQueue<Integer> heap =  new PriorityQueue<>();
		for(int a: arr) {
			heap.offer(a);
			if(heap.size()> i) {
				heap.poll();
			}
		}
		
		return heap.peek();
	}
	
	private static int findKthLargestHeap(int[] arr, int i) {
		HeapSort heap =  new HeapSort(arr.length);
		for(int a: arr) {
			heap.offer(a);
			if(heap.size()> i) {
				heap.poll();
			}
		}
		
		return heap.peek();
	}
	
	
	static class HeapSort{
	
		int array[] ;
		
		int size = 0;
		

		
		HeapSort(int size){
			array = new int[size+1];
		}
		
		
	public int size() {
			return size;
		}


	public void offer(int r) {
		
		array[size] = r;   
		
		size++;
		
        heapify(array, size, (size-2)/2);
	}
	
	public int poll() {
		int poll = array[0];
		
		array[0] = array[size-1];
		size--;
		heapify(array, size, 0);
		return poll;
	}

	public int peek() {
		return array[0];
	}
	
	private void heapify(int[] arr, int size, int root) {

	        int largest = root;	
	        int left = 2*largest+1;
	        int right = 2*largest+2;
	
	         if(left < size 
	        		 && arr[left] < arr[largest]) {
	        	 largest = left; 
	         }else if(right < size 
	        		 && arr[right] < arr[largest]) {
	        	 largest = right; 
	         }
	         
	         if(largest != root) {
	        	 swap( root, largest);
	        	 heapify(arr, size, (largest-2)/2); 
	         }
	}


	private void swap(int right, int parent) {
		int temp = array[parent];
		array[parent] = array[right];
		array[right] = temp;
	}	
		
	}

}
