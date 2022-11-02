package org.algoritham.twoPointer;

public class ContainerWithMostWater {


    /**
     * Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
     * 
N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     * 
     * @param args
     */
    public static void main(String[] args) {
        assert maxArea(new int[]{1, 5, 4, 3}) == 6;
    }

    public static int maxArea(int[] A) {
        int ans =0;
        int start = 0, end = A.length -1;

        while(start< end){
            
           if(A[start] < A[end]){
            ans = Math.max(A[start] * (end - start), ans);
            start++;
           }else{
            ans = Math.max(A[end] * (end - start), ans);
            end--;
           }

        }


        return ans;
    }
    
}
