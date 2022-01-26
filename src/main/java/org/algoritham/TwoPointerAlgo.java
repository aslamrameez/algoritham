import java.util.*;
public class MyClass {
    public static void main(String args[]) {
     int[] input = {-3, 0, 1, 2, -1, 1, -2};
     Arrays.sort(input);
     List<List<Integer>> triplet = new ArrayList<>();
     for(int i=0; i<input.length-1;i++){
         if(i>0 && input[i] == input[i-1])
         continue;
          findMetrix(input, -input[i], i+1, triplet);
     }
     System.out.println("triplet.  "+ triplet);
     
    }
    
    public static void findMetrix(int[] input, int key, int start, List<List<Integer>> triplet){
        int left = start, right = input.length-1;
        while(left<right){
            int currentSum = input[left] + input[right];
            if(key  == currentSum){
                triplet.add(Arrays.asList(-key, input[left], input[right]));
            left++;
            right--;
                while(left<right && input[right] == input[right +1])
                right--;
                while(left<right && input[left] == input[left -1])
                left++;
            }else if(key  > currentSum){
                left++;
            }else{
                right--;
            }
            
        }
        
    }
}
