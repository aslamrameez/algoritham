package org.algoritham;

import java.util.Arrays;

public class NextBiggestNumber {

	public static void main(String[] args) {
		printnextbiggest("4765");

	}

	private static void printnextbiggest(String num) {
		char[] charArray = num.toCharArray();
		int r=-1;
		
		for (int i = charArray.length -1 ; i >0 ; i--) {
			if(charArray[i] > charArray[i -1]) {
				r = i;
				char temp = charArray[r-1];
				charArray[r-1] = charArray[charArray.length -1];
				charArray[charArray.length -1] = temp;
				break;
			}	
		}
		
		if(r  == -1)
			System.out.println("No Highest");
		else {
			
			
		Arrays.sort(charArray, r, charArray.length );
		
		System.out.println(new String(charArray));
		}
	}

}
