package org.algoritham.stack;

import java.util.Stack;

public class RemoveDuplicate {

    public static void main(String[] args) {
        RemoveDuplicate duplicate  = new RemoveDuplicate();
        System.out.println(duplicate.solve("cddfeffe"));
    }


    String solve(String A){

        Stack<Character> str = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if(str.isEmpty())str.push(A.charAt(i));
            else if(str.peek() == A.charAt(i)){
                str.pop();
            }else{
                str.push(A.charAt(i));   
            }   
        }
        StringBuilder ans = new StringBuilder();
        int size = str.size();
        for (int i = 0; i < size; i++) {
            ans.append(str.pop()) ;
        }
      return ans.reverse().toString();
    }

    
}
