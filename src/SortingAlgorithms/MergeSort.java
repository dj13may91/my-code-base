package SortingAlgorithms;

public class MergeSort {
    public static int numberOfTimesMergeCalled = 0;

    public static void merge(int arr[], int start, int mid, int end) {
        numberOfTimesMergeCalled++;
        System.out.println("current array is : ");
        print(arr);
        int leftArrSize = mid - start + 1;
        int rightArrSize = end - mid;
        int left[] = new int[leftArrSize];
        int right[] = new int[rightArrSize];

        for (int i = 0; i < leftArrSize; i++) {
            left[i] = arr[start + i];
        }

        for (int i = 0; i < rightArrSize; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int leftStart = 0;
        int rightStart = 0;
        int originalArrayStart = start;

        while (leftStart < leftArrSize && rightStart < rightArrSize) {
            if (left[leftStart] <= right[rightStart]) {
                arr[originalArrayStart] = left[leftStart];
                leftStart++;
            } else {
                arr[originalArrayStart] = right[rightStart];
                rightStart++;
            }
            originalArrayStart++;
        }
        while (leftStart < leftArrSize) {
            arr[originalArrayStart] = left[leftStart];
            leftStart++;
            originalArrayStart++;
        }

        while (rightStart < rightArrSize) {
            arr[originalArrayStart] = right[rightStart];
            rightStart++;
            originalArrayStart++;
        }
    }

    public static void sort(int arr[], int start, int end) {
        // If array is not of size one, split it in half!! conquer it!!
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            System.out.println("\ncalling merge for start : " + start + ", mid: " + mid + ", end: " + end);
            merge(arr, start, mid, end);
        }
    }

    public static void print(int arr[]) {
        for (int i : arr) {
            System.out.print(" -> " + i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 7, 8, 0, 6, 1}; //{'a', 'd', 'f', 'b', 'e', 'c'}; //
        sort(arr, 0, arr.length - 1);
        System.out.println("sorted array : ");
        print(arr);
        System.out.println("Merging of array is done [N - " + (arr.length - numberOfTimesMergeCalled) + "] times");
    }
}

/**
 Output:
 calling merge for start : 0, mid: 0, end: 1
 current array is :
 -> 3 -> 2 -> 4 -> 5 -> 7 -> 8 -> 0 -> 6 -> 1

 calling merge for start : 0, mid: 1, end: 2
 current array is :
 -> 2 -> 3 -> 4 -> 5 -> 7 -> 8 -> 0 -> 6 -> 1

 calling merge for start : 3, mid: 3, end: 4
 current array is :
 -> 2 -> 3 -> 4 -> 5 -> 7 -> 8 -> 0 -> 6 -> 1

 calling merge for start : 0, mid: 2, end: 4
 current array is :
 -> 2 -> 3 -> 4 -> 5 -> 7 -> 8 -> 0 -> 6 -> 1

 calling merge for start : 5, mid: 5, end: 6
 current array is :
 -> 2 -> 3 -> 4 -> 5 -> 7 -> 8 -> 0 -> 6 -> 1

 calling merge for start : 7, mid: 7, end: 8
 current array is :
 -> 2 -> 3 -> 4 -> 5 -> 7 -> 0 -> 8 -> 6 -> 1

 calling merge for start : 5, mid: 6, end: 8
 current array is :
 -> 2 -> 3 -> 4 -> 5 -> 7 -> 0 -> 8 -> 1 -> 6

 calling merge for start : 0, mid: 4, end: 8
 current array is :
 -> 2 -> 3 -> 4 -> 5 -> 7 -> 0 -> 1 -> 6 -> 8
 sorted array :
 -> 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
 Merging of array is done [N - 1] times
 */