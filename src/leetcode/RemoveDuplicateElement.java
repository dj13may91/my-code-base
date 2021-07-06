package leetcode;

public class RemoveDuplicateElement {

  public static void main(String[] args) {
//    int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
//    int[] arr = {3, 2, 2, 3};
    int[] arr = {2, 2, 2};
    System.out.println(removeElement(arr, 2));
  }

  public static void swap(int[] nums, int a, int b) {
    nums[a] = nums[a] + nums[b];
    nums[b] = nums[a] - nums[b];
    nums[a] = nums[a] - nums[b];
  }

  public static int removeElement(int[] nums, int val) {
    int start = 0;
    int end = nums.length - 1;
    while (end >= start) {
      if (nums[start] == val) {
        while (end >= 0 && nums[end] == val) {
          end--;
        }
        if (end > start) {
          swap(nums, start, end);
        }
      } else {
        start++;
      }
    }
//    System.out.println(Arrays.toString(nums));
    return end + 1;
  }
}
