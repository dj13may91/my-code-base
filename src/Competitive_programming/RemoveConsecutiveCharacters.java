package Competitive_programming;

/**
 * remove consecutive K equal characters from a string.
 * Example 1: aabbcccaa , k=3 => aabbaa
 * Example 2: aabbcccaa, 2 => c
 */
public class RemoveConsecutiveCharacters {

    public static void main(String[] args) {
        String str = "aabbcccaa";
        int k = 2;
        String previous = "";
        while (!str.equals(previous)) {
            previous = str;
            str = compress(str, k);
        }
        System.out.println(compress(str, k));
    }

    public static String compress(String str, int k) {
        char ch[] = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (isKConsecutive(ch, ch[i], k, i)) {
                i = i + k - 1;
            } else {
                builder.append(ch[i]);
            }
        }
        return String.valueOf(builder);
    }

    public static boolean isKConsecutive(char str[], char ch, int K, int startFrom) {
        for (int i = 0; i < K; i++)
            if (i + startFrom >= str.length || str[i + startFrom] != ch)
                return false;
        return true;
    }
}
