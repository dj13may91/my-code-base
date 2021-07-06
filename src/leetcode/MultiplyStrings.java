package leetcode;

import java.util.Arrays;

public class MultiplyStrings {

  public static void main(String[] args) {
    String num1 = "99";
    String num2 = "900";
    System.out.println(multiply(num1, num2));
    int res = Integer.parseInt(num1) * Integer.parseInt(num2);
    System.out.println(res);
  }

  public static String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }

    int[] res = new int[num1.length() + num2.length()];
    for (int i = num1.length() - 1; i >= 0; i--) {
      for (int j = num2.length() - 1; j >= 0; j--) {
        int pos = i + j + 1;
        int carry = res[pos];
        int currVal = ((num2.charAt(j) - '0') * (num1.charAt(i) - '0')) + carry;
        res[pos] = currVal % 10;
        res[pos-1] += currVal / 10;
        System.out.println(Arrays.toString(res));
      }
    }
    int pointer = 0;
    while(res[pointer] == 0){
      pointer++;
    }
    StringBuilder builder = new StringBuilder();
    for(int i=pointer; i<res.length ; i++){
      builder.append(res[i]);
    }
    return String.valueOf(builder);
  }

  public static int getCurrNum(String num, int index) {
    return num.charAt(index) - '0';
  }
}
