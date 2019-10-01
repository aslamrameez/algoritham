package org.algoritham;

public class MathAlgo {

	public static void main(String[] args) {
		int n = 50;
		
		System.out.println("Square root of "
                + n + " is " + squareRoot(n)); 
		
		System.out.println("Is perfect square "+ isPerefectSq(49));
		int[] number =  {1, 2, 4, 6, 3, 7, 8};
		System.out.println("Missing number " + missingNumber(number));
		System.out.println("Missing number xor " + usingXORmissingNumber(number));
	}

	private static int missingNumber(int[] number) {
		int n = number.length;
		
		int sum = (n+1)*(n+2)/2;
		
		for (int i = 0; i < number.length; i++) {
			sum -=number[i];
		}
		
		return sum;
	}
	
	
	private static int usingXORmissingNumber(int[] number) {
		int x1 = number[0];
		int x2 =1;
		
		for (int i = 1; i < number.length; i++) {
			x1 ^=number[i];
		}
		
		for (int i = 2; i <= number.length+1; i++) {
			x2 ^=i;
		}
		
		return x1^x2;
	}

	private static boolean isPerefectSq(int n) {
		
		for(int i =1 ; i*i <=n; i++) {
		
			if(n%i == 0 && n/i == i) {
				return true;
			}
		}
		return false;
	}

	// Newton–Raphson method.
	private static float squareRoot(int n) {
		
		float x = n; 
        float y = 1; 
        
        double e = 0.000001; 
        while (x - y > e) { 
            x = (x + y) / 2; 
            y = n / x; 
        } 
        return x; 
	}

}
