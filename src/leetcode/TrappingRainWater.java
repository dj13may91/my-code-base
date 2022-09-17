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
        int water = 0, left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;

        while (left < right) {
            if (leftMax < height[left]) leftMax = height[left];
            if (rightMax < height[right]) rightMax = height[right];
            if (leftMax < rightMax) {
                water = water + Math.max(0, leftMax - height[left]);
                left++;
            } else {
                water = water + Math.max(0, rightMax - height[right]);
                right--;
            }
        }
        return water;
    }
}
