package org.algoritham;

public class FindSubString {

	static final int no_of_chars = 256;

	public static void main(String[] args) {
		String str = "this isr at te rt string";
		String pat = "rts";

		System.out.print("Smallest window is :\n " + findSubString(str, pat));

	}

	static String findSubString(String str, String pat) {

		int len1 = str.length();
		int len2 = pat.length();

		// check if string's length is less than pattern's
		// length. If yes then no such window can exist
		if (len1 < len2) {
			System.out.println("No such window exists");
			return "";
		}
		int hash_pat[] = new int[no_of_chars];
		int hash_str[] = new int[no_of_chars];

		for (int i = 0; i < len2; i++)
			hash_pat[pat.charAt(i)]++;

		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

		int count = 0;

		for (int j = 0; j < len1; j++) {
			hash_str[str.charAt(j)]++;

			if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
				count++;

			if (count == len2) {
				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {

					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}

				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}

		if (start_index == -1) {
			System.out.println("No such window exists");
			return "";
		}

		return str.substring(start_index, start_index + min_len);
	}
}
