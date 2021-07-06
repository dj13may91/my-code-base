package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {

  public static void main(String[] args) {
    int[] arr = {9,9,9};
    int target = 9;
    System.out.println(combinationSum(arr, target));
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> response = new ArrayList<>();
    Arrays.sort(candidates);
    recursion(response, candidates, target, new ArrayList<>(), 0);
    return response;
  }

  public static void recursion(List<List<Integer>> res, int[] arr, int target, List<Integer> curr,
      int i) {
    if (i >= arr.length) {
      if (target == 0) {
        res.add(new ArrayList<>(curr));
      }
      return;
    }

    if (arr[i] <= target) {
      curr.add(arr[i]);
      recursion(res, arr, target - arr[i], curr, i + 1);
      curr.remove(curr.size() - 1);
    }
    int nextIndex = i + 1;
    while (nextIndex < arr.length && arr[i] == arr[nextIndex]) {
      nextIndex++;
    }
    recursion(res, arr, target, curr, nextIndex);
  }
}
