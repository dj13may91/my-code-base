package dynamic_programming;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given an even number (greater than 2), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only first such pair.
 *
 * NOTE: A solution will always exist, read Goldbach’s conjecture. Also, solve the problem in linear time complexity, i.e., O(n).
 *
 * Input:
 * The first line contains T, the number of test cases. The following T lines consist of a number each, for which we'll find two prime numbers.
 *
 * Note: The number would always be an even number.
 *
 * Output:
 * For every test case print two prime numbers space separated, such that the smaller number appears first. Answer for each test case must be in a new line.
 *
 * Constraints:
 * 1 ≤ T ≤ 70
 * 1 ≤ N ≤ 10000
 *
 * Example:
 * Input:
 * 5
 * 74
 * 1024
 * 66
 * 8
 * 9990
 *
 * Output:
 * 3 71
 * 3 1021
 * 5 61
 * 3 5
 * 17 9973
 */

public class PrimeNumberPair {

  private static Set<Integer> primeNumbers = new HashSet<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int count = Integer.parseInt(scanner.next());
    primeNumbers.add(2);
    while (count-- > 0) {
      int num = Integer.parseInt(scanner.next());
      int small = 2;
      int large = num - 2;
      while (small < large) {
        if (isPrime(small) && isPrime(large)) {
          break;
        } else {
          small++;
          large--;
        }
      }
      if (small < large) {
        System.out.println(small + " " + large);
      } else {
        System.out.println(large + " " + small);
      }
    }
  }

  private static boolean isPrime(int num) {
    if ((num <= 1) || (num > 2 && num % 2 == 0)) {
      return false;
    }

    if (primeNumbers.contains(num)) {
      return true;
    }

    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    primeNumbers.add(num);
    return true;
  }
}

