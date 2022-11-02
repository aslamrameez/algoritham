package org.algoritham.string;

public class PeriodOfString {

    public static void main(String[] args) {
        int ans = solve("ababab");

        assert ans == 5;
    }


    public static int solve(String A) {

        int[] lps = new int[A.length()];
        
        for(int i=1; i< A.length(); i++){
            int x = lps[i -1];

            while(A.charAt(i) != A.charAt(x)){
                 if(x == 0){ x =-1; break;}
                 x = lps[x -1];
            }
          lps[i] = x + 1;
        }

        for (int i = 0; i < lps.length; i++) {
            System.out.print(lps[i] +"  ");
        }

        return A.length() - lps[lps.length -1];
    }
    
}
