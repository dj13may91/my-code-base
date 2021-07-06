package leetcode;

public class TrappingRainWater {

  public static void main(String[] args) {
    int[] arr =
//        {4, 2, 0, 3, 2, 5, 2, 3};
        {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(arr));
  }

  public static int trap(int[] height) {
    if (height.length < 3) {
      return 0;
    }

    int leftMax, rightMax;
    int left = 0, right = height.length - 1;
    if (height[left] < height[right]) {
      //
    } else if (height[left] >= height[right]) {
      //
    }
    return 1;
  }
}
