package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 4, 1, 2, -1, -3, -1}; // -4,-1,-1,0,1,2,4
    threeSum(nums);
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> solution = new ArrayList<>();
    Arrays.sort(nums);
//    System.out.println(Arrays.toString(nums));
    int curr = 0;
    while (curr < nums.length - 1) {
//      System.out.println("curr = " + curr);
      for (int i = curr + 1; i < nums.length; i++) {
        int index = binarySearch(nums, -(nums[curr] + nums[i]), i + 1, nums.length - 1);
        if (index > 0) {
//          System.out.println(curr + ", " + i + ", " + index);
          solution.add(Arrays.asList(nums[curr] , nums[i] ,nums[index]));
          if (isSame(nums, i)) {
            while (isSame(nums, i)) {
              i++;
            }
          }
        }
      }
      if (isSame(nums, curr)) {
        while (isSame(nums, curr)) {
          curr++;
        }
      }
      curr++;
    }
    System.out.println(solution);
    return solution;
  }

  private static boolean isSame(int[] nums, int index) {
    return (index < (nums.length - 1)) && nums[index] == nums[index + 1];
  }

  public static int binarySearch(int[] a, int val, int low, int high) {
    while (low <= high) {
      int mid = (low + high) / 2;
      if (a[mid] == val) {
        return mid;
      } else if (a[mid] < val) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:   Input: nums = [-1,0,1,2,-1,-4]  => Output: [[-1,-1,2],[-1,0,1]]
Example 2:   Input: nums = []  =>  Output: []
Example 3:   Input: nums = [0]   =>    Output: []
* */
