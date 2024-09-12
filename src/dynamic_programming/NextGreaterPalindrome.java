package dynamic_programming;
// uber
// https://www.geeksforgeeks.org/given-a-number-find-next-smallest-palindrome-larger-than-this-number/
public class NextGreaterPalindrome {
    public static void main(String[] args) {
//        int num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
//        int[] num = {1, 2, 3, 3, 1};
//        int[] num = {9, 9, 9};
//        int[] num = {7, 8, 3, 3, 2, 2};
//        int[] num = {1, 2, 5, 3, 2, 2};
        int[] num = {1, 4, 5, 8, 7, 6, 7, 8, 3, 2, 2};
        System.out.println(nextValidPalindrome(num));
    }

    private static String nextValidPalindrome(int[] num) {
        if (isAll9s(num)) {
            return 1 + "0".repeat(Math.max(0, num.length - 1)) + 1;
        }

        int len = num.length;
        int left = (len - 1) / 2;
        int right = len / 2;
        while (left > 0) {
            if (num[left] < num[right]) {
                num[left]++;
                for (int i = left + 1; i < right; i++) num[i] = 0;
            }
            num[right] = num[left];
            left--;
            right++;
        }
        num[right] = num[left];
        return Arrays.toString(num);
    }

    private static boolean isAll9s(int[] num) {
        for (int j : num) {
            if (j != 9) return false;
        }
        return true;
    }
}
