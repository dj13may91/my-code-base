package SortingAlgorithms;

import java.util.Arrays;

public class MaxHeapSort {

  public static int[] maxHeap = new int[10];
  private static int[] arr = {1, 5, 9, 3, 6, 2, 10, 4, 8, 7};

  public static void main(String[] args) {
    int index = 0;
    while (index < 10) {
      for (int i = getParent(arr.length - 1); i >= 0; i--) { //start with last parent
        heapify(arr, i);
      }
      maxHeap[index++] = arr[0];
      arr[0] = -1;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(maxHeap));
  }

  private static void heapify(int[] arr, int currentParent) {
    if (!hasLeftChild(currentParent) && !hasRightChild(currentParent)) {
      return;
    }
    if (hasLeftChild(currentParent) && hasRightChild(currentParent)) {
      if (Math.max(leftChild(currentParent), rightChild(currentParent)) > arr[currentParent]) {
        if (leftChild(currentParent) > rightChild(currentParent)) {
          swapLeft(currentParent);
        } else {
          swapRight(currentParent);
        }
      }
    } else if (hasLeftChild(currentParent) && leftChild(currentParent) > arr[currentParent]) {
      swapLeft(currentParent);
    } else if (hasRightChild(currentParent) && rightChild(currentParent) > arr[currentParent]) {
      swapRight(currentParent);
    }
  }

  private static void swapLeft(int parent) {
    int temp = arr[parent];
    arr[parent] = leftChild(parent);
    arr[getLeftIndex(parent)] = temp;
    heapify(arr, getLeftIndex(parent));
  }

  private static void swapRight(int parent) {
    int temp = arr[parent];
    arr[parent] = rightChild(parent);
    arr[getRightIndex(parent)] = temp;
    heapify(arr, getRightIndex(parent));
  }

  private static boolean hasRightChild(int parent) {
    return getRightIndex(parent) < arr.length;
  }

  private static boolean hasLeftChild(int parent) {
    return getLeftIndex(parent) < arr.length;
  }

  private static int getLeftIndex(int parent) {
    return (2 * parent) + 1;
  }

  private static int getRightIndex(int parent) {
    return (2 * parent) + 2;
  }

  private static int getParent(int index) {
    return (index - 1) / 2;
  }

  private static int leftChild(int i) {
    return arr[getLeftIndex(i)];
  }

  private static int rightChild(int i) {
    return arr[getRightIndex(i)];
  }
}
