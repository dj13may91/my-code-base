package Competitive_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Source and target string.
 * By just updating 1 character in source, try and see if we can obtain target string.
 * 4 allowed operations:
 * 1: Insert 1 character => return "INSERT  a"
 * 2: replace 1 character => return "REPLACE c a
 * 3: Swap 2 character in source string => return "SWAP a b"
 * 4: No changes required => return "EQUALS"
 * if none of the above is possible, return "IMPOSSIBLE"
 * EXAMPLE:
 * nice nicer > return "INSERT r"
 * test tent => return "REPLACE s n"
 * from form => return "SWAP r o"
 * abc abcde => return "IMPOSSIBLE"
 */

public class ObtainString {

    public static void main(String[] args) {
        String s = "nicer";
        String t = "niecr";
        ObtainString str = new ObtainString();
        System.out.println(str.solution(s, t));
    }


    public String solution(String S, String T) {
        // write your code in Java SE 8
        if (S.equals(T))
            return "EQUALS";

        if (S.length() - T.length() >= 2 || S.length() - T.length() <= -2)
            return "IMPOSSIBLE";

        if (T.length() - S.length() == 1) {
            return insertNewCharacter(S.toCharArray(), T.toCharArray());
        }

        if (S.length() == T.length()) {
            if (isAnagram(S.toCharArray(), T.toCharArray())) {
                return getAnagramResult(S.toCharArray(), T.toCharArray());
            } else {
                return replaceCharacter(S.toCharArray(), T.toCharArray());
            }
        }
        return "IMPOSSIBLE";
    }

    //case 1: anagram
    public boolean isAnagram(char source[], char target[]) {
        List<Character> charSet = checkCommonCharacters(source, target);

        if (charSet.size() == 0)
            return true;
        return false;
    }

    private List<Character> checkCommonCharacters(char[] source, char[] target) {
        List<Character> charSet = new ArrayList<>();
        for (char ch : target)
            charSet.add(ch);

        for (char ch : source)
            charSet.remove((Character) ch);
        return charSet;
    }

    public String getAnagramResult(char source[], char target[]) {
        int misMatchCount = 0;
        int mismatchIndex[] = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            if (source[i] != target[i]) {
                mismatchIndex[misMatchCount] = i;
                misMatchCount++;
            }
            // more than 2 characters are to be replaced
            if (misMatchCount > 2) {
                return "IMPOSSIBLE";
            }
        }
        return "SWAP " + source[mismatchIndex[0]] + " " + source[mismatchIndex[1]];
    }

    //case 2 replace character
    public String replaceCharacter(char source[], char target[]) {
        int index = -1;
        int count = 0;

        for (int i = 0; i < source.length; i++) {
            if (source[i] != target[i]) {
                index = i;
                count++;
            }
            if (count > 1) {
                return "IMPOSSIBLE";
            }
        }


        if (count == 1) {
            return "REPLACE " + source[index] + " " + target[index];
        }
        return "IMPOSSIBLE";
    }

    // case 3: insert new character
    public String insertNewCharacter(char source[], char target[]) {
        List<Character> charSet = checkCommonCharacters(source, target);
        if (charSet.size() == 1) {
            return "INSERT " + charSet.get(0);
        }
        return "IMPOSSIBLE";
    }
}
