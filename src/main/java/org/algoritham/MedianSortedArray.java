package org.algoritham;

public class MedianSortedArray {

	public static void main(String[] args) {

		int []a = new int[]{900}; 
		int []b = new int[]{10, 13, 14}; 
	System.out.println("The median is : "+	findMedianSortedArrays(a, b));
	
	int ar1[] = new int[]{-5, 3, 6, 12, 15};
	int ar2[] = new int[]{-12, -10, -6, -3, 4, 10};
	
	System.out.println("The median is : "+	findMedianSortedArrays(ar1, ar2));
	
	int a1[] = new int[]{2, 3, 5, 8};
	int a2[] = new int[]{10, 12, 14, 16, 18, 20};
	
	System.out.println("The median is : "+	findMedianSortedArrays(a1, a2));
	

	}

	private static double findMedianSortedArrays(int[] a, int[] b) {
		
		int n = a.length , m = b.length;
		int min_index = 0,  
	            max_index = n, i = 0, 
	            j = 0, median = 0; 
		
		  while (min_index <= max_index) { 
			  
			  i = (min_index + max_index) / 2; 
	          j = ((n + m + 1) / 2) - i; 
	          
	          
	          if (i < n && j > 0 && b[j - 1] > a[i])      
	                min_index = i + 1; 
	          else if (i > 0 && j < m && b[j] < a[i - 1])      
	                max_index = i - 1; 
	          else
	            {
	        	  if (i == 0)          
	                    median = b[j - 1];  
	        	  else if (j == 0)          
	                    median = a[i - 1];          
	              else    
	                    median = Math.max(a[i - 1],  
	                                     b[j - 1]);          
	              break; 
	            }
	            
	        }
		  if ((n + m) % 2 == 1) 
	            return median; 
		  if (i == n) 
	            return (median + b[j]) / 2.0; 
		  
		  if (j == m) 
	            return (median + a[i]) / 2.0; 
		
		  return (median + Math.min(a[i],  
                  b[j])) / 2.0;
	}

}
