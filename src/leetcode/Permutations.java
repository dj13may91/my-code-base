package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public static void main(String[] args) {
    int nums[] = {1, 2, 3};
    System.out.println(permute(nums));
  }

  public static void permute(int[] nums, int fixedIndex, List<List<Integer>> res) {
    if (fixedIndex == nums.length - 1) {
      List<Integer> currPermutation = new ArrayList<>();
      for(int i: nums){
        currPermutation.add(i);
      }
      res.add(currPermutation);
      return;
    }
    for (int i = fixedIndex; i < nums.length; i++) {
      swap(nums, fixedIndex, i);
      permute(nums, fixedIndex + 1, res);
      swap(nums, fixedIndex, i);
    }
  }

  private static void swap(int[] nums, int fixedIndex, int i) {
    int temp = nums[fixedIndex];
    nums[fixedIndex] = nums[i];
    nums[i] = temp;
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    permute(nums, 0, res);
    return res;
  }

}
