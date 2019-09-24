package org.algoritham;

public class ElementPivotedArray {

	public static void main(String[] args) {
		int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
		
		int searchTerm = 1; 
		
		int i = search(arr, 0, arr.length -1, searchTerm);
	        if (i != -1)  
	            System.out.println("Index: " + i); 
	        else
	            System.out.println("Key not found"); 
	        
	   System.out.println("find min "+ findMin(arr, 0, arr.length -1));
	   
	   System.out.println("find min "+ findMin(new int[]{-1, 2, 3, 4}, 0, 3));
	}

	private static int findMin(int[] arr, int l, int h) {
		
		if(l > h)
			return arr[0];
		
		if (l == h) return arr[l]; 
		
		int mid = (l+h)/2;
		
		if (l < h && arr[mid+1] < arr[mid]) 
            return arr[mid+1]; 
  
       
        if (l > h && arr[mid] < arr[mid - 1]) 
            return arr[mid];
		
		if(arr[mid] > arr[h]) {
			return findMin(arr, mid+1, h);
		}else {
			return findMin(arr, l, mid);	
		}
	}

	private static int search(int[] arr, int l, int h, int searchTerm) {
		
		  if (l > h)  
	            return -1; 
		  
		  int mid = (l+h)/2;
		  
		  if (arr[mid] == searchTerm) 
	            return mid; 
		  
		  if (arr[l] <= arr[mid]) {
			  
			  if (searchTerm >= arr[l] && searchTerm < arr[mid]) 
	               return search(arr, l, mid-1, searchTerm); 
			 
			  return search(arr, mid+1, h, searchTerm); 
		  }
		  
		  if (searchTerm >= arr[mid] && searchTerm <= arr[h]) 
	            return search(arr, mid+1, h, searchTerm);
		  
		return search(arr, l, mid-1, searchTerm);
	}

}
