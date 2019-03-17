/**
 Input will be a palindrome. Change the input to minimum of a string by replacing one character such that it is no more
 a palindrome. If not possible, return IMPOSSIBLE
 Example:
 abba -> aaba
 aaa -> IMPOSSIBLE , WHY ? as there is no string smaller than aaa
 */
package Competitive_programming;

public class BreakThePalindrome {

    public static void main(String[] args) {
        String str = "acca";
        for(char j= 'a'; j<= 'z'; j++){
            char strArray[] = str.toCharArray();
            for(int i=0; i< strArray.length; i++){
                strArray[i] = j;
                if(!isPalindrome(String.valueOf(strArray)) && str.compareTo(String.valueOf(strArray)) > 0){
                    System.out.println(String.valueOf(strArray));
                    System.exit(0);
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    public static boolean isPalindrome(String s){
        int n = s.length();
        for (int i = 0; i < (n/2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
