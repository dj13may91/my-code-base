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
                arr = swap(arr, low, high);
                print(arr);
                swapCount++;
            }
        }
        swap(arr, endIndex, low);
        System.out.println("Array after pivot element swap with low at: " + low + " and pivot at: " + endIndex);
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
