package org.algoritham;

public class LongestPalindromSubstring {
	
	
	public static void main(String[] args) {
		String str = "forgeeksskeegfor"; 
		
		System.out.println(longestPalSubstrBFM(str));
		System.out.println(longestPalSubstr(str));
		
	}
	
	private static String longestPalSubstr(String str) {
		int n = str.length();
		boolean[][] table = new boolean[n][n];
		int maxLength = 1; 
        for (int i = 0; i < n; ++i) 
            table[i][i] = true; 
        
        // check for sub-string of length 2. 
        int start = 0; 
        for (int i = 0; i < n - 1; ++i) { 
            if (str.charAt(i) == str.charAt(i + 1)) { 
                table[i][i + 1] = true; 
                start = i; 
                maxLength = 2; 
            } 
        } 
        
     // Check for lengths greater than 2. k is length 
        // of substring 
        for (int k = 3; k <= n; ++k) { 
              
                  // Fix the starting index 
            for (int i = 0; i < n - k + 1; ++i)  
            { 
                // Get the ending index of substring from 
                // starting index i and length k 
                int j = i + k - 1; 
  
                // checking for sub-string from ith index to 
                // jth index iff str.charAt(i+1) to  
                // str.charAt(j-1) is a palindrome 
                if (table[i + 1][j - 1] && str.charAt(i) ==  
                                          str.charAt(j)) { 
                    table[i][j] = true; 
  
                    if (k > maxLength) { 
                        start = i; 
                        maxLength = k; 
                    } 
                } 
            } 
        } 
		return str.substring(start, start + maxLength );
	}

	private static String longestPalSubstrBFM(String str) {
	
		String substirng = "";
		int length = str.length();
		int maxlength  = 0;
	   for (int i = 0; i < length; i++) {
			for (int j = length ; j > i; j--) {
				if(isPalindrom(str.substring(i, j)) 
						&& maxlength< (j-i)) {
					substirng = str.substring(i, j);
					maxlength = substirng.length();
				}
			}
		}
		return substirng;
	}
	
	
	public static boolean isPalindrom(String str) {
		boolean palindrom = true;
		int size = (str.length() -1);
	    for (int i = 0; i <= size/2; i++) {
			if(str.charAt(i) != str.charAt(size - i)) {
				palindrom =false;
				break;
			}
		}
		return palindrom;
	}

}
