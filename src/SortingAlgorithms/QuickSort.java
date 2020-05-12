package SortingAlgorithms;


/**
 * Complexity: O(N logN)
 */
public class QuickSort {

  public static void sort(int arr[], int currLow, int currHigh) {
    if (currHigh > currLow) {
      int j = partition(arr, currLow, currHigh);
      System.out.println();
      sort(arr, currLow, j - 1);
      sort(arr, j + 1, currHigh);
    }
  }


  public static int partition(int arr[], int startIndex, int endIndex) {
    int low = startIndex;
    int high = endIndex;
    int pivot = arr[high];
    int swapCount = 0;
    System.out.println("startIndex: " + startIndex + ", endIndex: " + endIndex);
    print(arr);
    System.out.println("pivot : " + pivot + ", at position: " + high);
    while (low < high) {
      while (arr[low] < pivot) {
        low++;
      }
      while (arr[high] >= pivot) {
        high--;
      }
      System.out.println("low: " + low + ", high: " + high);
      if (low < high) {
        System.out.println("calling swap , array after swap as below: ");
        swap(arr, low, high);
        print(arr);
        swapCount++;
      }
    }
    swap(arr, endIndex, low);
    System.out.println(
        "Array after pivot element swap with low at: " + low + " and pivot at: " + endIndex);
    print(arr);
    System.out.println("total swaps done: " + swapCount + ", returning: " + low);
    return low;
  }

  private static int[] swap(int[] arr, int low, int high) {
    int temp = arr[low];
    arr[low] = arr[high];
    arr[high] = temp;
    return arr;
  }

  public static void print(int arr[]) {
    System.out.print("current array ");
    for (int i : arr) {
      System.out.print(" -> " + i);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int arr[] = {10, 7, 8, 9, 1, 5}; // {0, 5, 1, 4, 2, 2, 7, 9, 8};
    sort(arr, 0, arr.length - 1);
  }
}

/**
 * output: startIndex: 0, endIndex: 5 current array  -> 10 -> 7 -> 8 -> 9 -> 1 -> 5 pivot : 5, at
 * position: 5 low: 0, high: 4 calling swap , array after swap as below: current array  -> 1 -> 7 ->
 * 8 -> 9 -> 10 -> 5 low: 1, high: 0 Array after pivot element swap with low at: 1 and pivot at: 5
 * current array  -> 1 -> 5 -> 8 -> 9 -> 10 -> 7 total swaps done: 1, returning: 1
 *
 * startIndex: 2, endIndex: 5 current array  -> 1 -> 5 -> 8 -> 9 -> 10 -> 7 pivot : 7, at position:
 * 5 low: 2, high: 1 Array after pivot element swap with low at: 2 and pivot at: 5 current array  ->
 * 1 -> 5 -> 7 -> 9 -> 10 -> 8 total swaps done: 0, returning: 2
 *
 * startIndex: 3, endIndex: 5 current array  -> 1 -> 5 -> 7 -> 9 -> 10 -> 8 pivot : 8, at position:
 * 5 low: 3, high: 2 Array after pivot element swap with low at: 3 and pivot at: 5 current array  ->
 * 1 -> 5 -> 7 -> 8 -> 10 -> 9 total swaps done: 0, returning: 3
 *
 * startIndex: 4, endIndex: 5 current array  -> 1 -> 5 -> 7 -> 8 -> 10 -> 9 pivot : 9, at position:
 * 5 low: 4, high: 3 Array after pivot element swap with low at: 4 and pivot at: 5 current array  ->
 * 1 -> 5 -> 7 -> 8 -> 9 -> 10 total swaps done: 0, returning: 4
 */
