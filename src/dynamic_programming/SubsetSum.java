package dynamic_programming;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the
 * given set with sum equal to given sum. Example:
 *
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9 Output:  True  // There is a subset (4, 5) with sum
 * 9.
 */
public class SubsetSum {

  private static int[] arr = {3, 34, 4, 12, 5, 2, 7};
  private static int SUM = 19;

  public static void main(String[] args) {
    for (int i = 0; i < arr.length; i++) {
      Set<Integer> subset = new HashSet<>();
      if (isSubSet(subset, arr[i], i)) {
        subset.add(i);
        System.out.println("Started from index:" + i + ", subset: " + subset);
      }
    }
  }

  private static boolean isSubSet(Set<Integer> subset, int currSum, int index) {
    if (currSum > SUM || index >= arr.length) {
      return false;
    }
    if ((index + 1 < arr.length && currSum + arr[index + 1] == SUM)) {
      subset.add(index + 1);
      return true;
    }
    if (currSum == SUM || isSubSet(subset, currSum, index + 1)) {
      return true;
    }
    if (isSubSet(subset, arr[index] + currSum, index + 1)) {
      subset.add(index);
      return true;
    }
    return false;
  }
}

/**
 * Sample output Started from index:0, subset: [0, 2, 5] Started from index:2, subset: [2, 4]
 * Started from index:5, subset: [5, 6]
 */
