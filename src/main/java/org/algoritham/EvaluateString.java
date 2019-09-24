package org.algoritham;

import java.util.Stack;

public class EvaluateString {
	
	
	public static void main(String[] args) {
		  //  System.out.println(evaluate("10 + 2 * 6")); 
	        System.out.println(evaluate("100 * 2 + 12")); 
	     //   System.out.println(evaluate("100 * ( 2 + 12 )")); 
	      //  System.out.println(evaluate("100 * ( 2 + 12 ) / 14")); 
	}

	private static Integer evaluate(String exp) {
		
		Stack<Character> opr  = new Stack<>();
		Stack<Integer> values  = new Stack<>();
		char[] charArray = exp.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			
			if(c == ' ')
				continue;
			 
			if(c >= '0' && c <= '9') {
				
				 StringBuffer sbuf = new StringBuffer(); 
	                // There may be more than one digits in number 
	                while (i < charArray.length && charArray[i] >= '0' && charArray[i] <= '9') 
	                    sbuf.append(charArray[i++]); 
	                values.push(Integer.parseInt(sbuf.toString()));     
				
			}
			
			else if(c == '(')
				opr.push(c);
			else if (charArray[i] == ')') {
				
				while(opr.peek() != '(')
					 values.push(applyOp(opr.pop(), values.pop(), values.pop()));
				opr.pop();
				
			}else {
				
				while (!opr.empty() && hasPrecedence(c, opr.peek())) 
	                  values.push(applyOp(opr.pop(), values.pop(), values.pop())); 
	  
				opr.push(c); 
			}
			
		}
		
		 while (!opr.empty()) 
	            values.push(applyOp(opr.pop(), values.pop(), values.pop())); 
	  
		
		return values.pop();
	}
	
	 public static boolean hasPrecedence(char op1, char op2) 
	    { 
	        if (op2 == '(' || op2 == ')') 
	            return false; 
	        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
	            return false; 
	        else
	            return true; 
	    }
	
	public static int applyOp(char op, int b, int a) 
	    { 
	        switch (op) 
	        { 
	        case '+': 
	            return a + b; 
	        case '-': 
	            return a - b; 
	        case '*': 
	            return a * b; 
	        case '/': 
	            if (b == 0) 
	                throw new
	                UnsupportedOperationException("Cannot divide by zero"); 
	            return a / b; 
	        } 
	        return 0; 
	    }

}
