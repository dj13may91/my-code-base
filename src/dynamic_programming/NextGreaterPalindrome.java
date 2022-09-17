package dynamic_programming;
// uber
public class NextGreaterPalindrome {
    public static void main(String[] args) {
        System.out.println(getNextGreaterPalindrome("1212"));
        System.out.println(getNextGreaterPalindrome("12"));
        System.out.println(getNextGreaterPalindrome("12222"));
    }

    public static String getNextGreaterPalindrome(String s) {
        int len = s.length();
        String response = "";
        boolean isPalindrome = isPalindrome(s);
        if (len % 2 == 0) { // even
            int left = Integer.parseInt(s.substring(0, s.length() / 2));
            StringBuilder res = new StringBuilder();
            res.append(left).append(new StringBuilder("" + left).reverse());
            if (s.compareTo(res.toString()) >= 0) {
                System.out.println(s + " -> even small: " + res);
                res = new StringBuilder(getNextEvenBig(s));
            }
            return String.valueOf(res);

        } else { // odd
            if (isPalindrome) {
                System.out.println("Already an odd palindrome");
                return getNextOddBig(s);
            }
            char mid = s.charAt(len / 2);
            StringBuilder sb = new StringBuilder();
            StringBuilder leftHalf = new StringBuilder(s.substring(0, len / 2));
            sb.append(leftHalf).append(mid).append(leftHalf.reverse());
            System.out.println(sb);
            if (s.compareTo(sb.toString()) >= 0) {
                System.out.println("odd small");
                sb = new StringBuilder(getNextOddBig(s));
            }
            System.out.println(sb);

        }
        return response;
    }

    private static String getNextEvenBig(String s) {
        int left = Integer.parseInt(s.substring(0, s.length() / 2));
        left++;
        return String.valueOf(left) + new StringBuilder(String.valueOf(left)).reverse();
    }

    public static String getNextOddBig(String s) {
        int left = Integer.parseInt(s.substring(0, s.length() / 2 + 1));
        left++;
        return String.valueOf(left) + new StringBuilder(String.valueOf(left / 10)).reverse();
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
