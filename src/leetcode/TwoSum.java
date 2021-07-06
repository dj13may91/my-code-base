package leetcode;
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {
    int nums[] = new int[]{3, 2, 4};
    int target = 6;
    System.out.println(Arrays.toString(twoSum(nums, target)));
  }

  public static int[] twoSum(int[] num, int target) {
    Map<Integer, Integer> numIndexMap = new HashMap<>();
    for (int i = 0; i < num.length; i++) {
      if (numIndexMap.get(target - num[i]) != null && numIndexMap.get(target - num[i]) != i) {
        return new int[]{i, numIndexMap.get(target - num[i])};
      }
      numIndexMap.put(num[i], i);
    }
    throw new IllegalArgumentException("invalid inputs");
  }
}
