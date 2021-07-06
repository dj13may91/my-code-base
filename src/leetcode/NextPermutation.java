package leetcode;

import java.util.Arrays;

public class NextPermutation {

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 3, 3};
    System.out.println(Arrays.toString(nums));
    nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void nextPermutation(int[] nums) {
    int pos = nums.length - 1;
    while (pos > 0 && (nums[pos - 1] >= nums[pos])) {
      pos--;
    }
    if (pos == 0) {
      reverse(nums, 0);
    } else {
      int small = pos - 1;
      //1,4,6,5,3
      int indexOfNextBigThanSmall = pos++;
      while (pos < nums.length) {
        if (nums[small] < nums[pos] && nums[indexOfNextBigThanSmall] >= nums[pos]) {
          indexOfNextBigThanSmall = pos;
        }
        pos++;
      }
      swap(nums, small, indexOfNextBigThanSmall);
      reverse(nums, small + 1);
    }
  }

  public static void reverse(int[] nums, int start) {
    int pos = nums.length - 1;
    while (start < pos) {
      swap(nums, pos--, start++);
    }
  }

  private static void swap(int[] nums, int pos, int i) {
    if (nums[i] == nums[pos]) {
      return;
    }
    nums[i] = nums[i] + nums[pos];
    nums[pos] = nums[i] - nums[pos];
    nums[i] = nums[i] - nums[pos];
  }
}
