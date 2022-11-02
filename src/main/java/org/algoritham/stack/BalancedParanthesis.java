package org.algoritham.stack;

import java.util.Stack;

public class BalancedParanthesis {

    public static void main(String[] args) {
        BalancedParanthesis balancedParanthesis =  new BalancedParanthesis();
       System.out.println(balancedParanthesis.solve("{([])}") );

       System.out.println(balancedParanthesis.solve("(){"));

    }

    int solve(String str){
        int ans =1;
        Stack<Character> stack =  new Stack<>();

        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }else if(!stack.isEmpty() && ((stack.peek() == '{' && str.charAt(i) == '}') || (stack.peek() == '[' && str.charAt(i) == ']') || (stack.peek() == '(' && str.charAt(i) == ')')) ){
                stack.pop();
            }else{
                ans =0;
                break;
            }
           
        }
        if(!stack.isEmpty()) ans =0;

       return ans;
    }
    
}
