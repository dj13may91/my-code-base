package leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/first-missing-positive/
public class LeastMissingPositive {

  public static void main(String[] args) {
    int[] nums = {1,1,1,1,1};
    System.out.println(firstMissingPositive(nums));
  }

  public static int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > nums.length || nums[i] <= 0) {
        nums[i] = -1;
      } else {
        if (swap(nums, i, nums[i] - 1)) {
          i--;
        }
      }
    }
    System.out.println(Arrays.toString(nums));
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }

  public static boolean swap(int[] nums, int i, int j) {
    if (i == j) {
      return false;
    }
    if (nums[i] == nums[j]) {
      if (i < j) {
        nums[j] = -1;
      } else {
        nums[i] = -1;
      }
      return false;
    }
    nums[i] = nums[j] + nums[i];
    nums[j] = nums[i] - nums[j];
    nums[i] = nums[i] - nums[j];
    return true;
  }
}
