//https://www.geeksforgeeks.org/binary-heap/

package Heap;

//1. Arr[(i-1)/2]	Returns the parent node.
//2. Arr[(2*i)+1]	Returns the left child node.
//3. Arr[(2*i)+2]	Returns the right child node.


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Implementing min heap here
public class MaxHeap<T> {

  private List<T> heapList = new ArrayList<>();
  private Comparator<T> comparator;
  private int lastNonLeafNode;

  public MaxHeap(List<T> heapList, Comparator<T> comparator) {
    this.heapList = heapList;
    this.comparator = comparator;
    lastNonLeafNode = getParentIndex(heapList.size() - 1);

    while (lastNonLeafNode >= 0) {
      heapify(lastNonLeafNode--);
    }
  }

  private void heapify(int leafIndex) {
    T left = leftChild(leafIndex);
    T right = rightChild(leafIndex);
    T root = heapList.get(leafIndex);
    int swappedIndex = -1;
    if (left != null && comparator.compare(root, left) < 0 && comparator.compare(left, right) > 0) {
      Collections.swap(heapList, leafIndex, getLeftIndex(leafIndex));
      swappedIndex = getLeftIndex(leafIndex);
    } else if (right != null && comparator.compare(root, right) < 0) {
      Collections.swap(heapList, leafIndex, getRightIndex(leafIndex));
      swappedIndex = getRightIndex(leafIndex);
    }
    if (swappedIndex != -1) {
      heapify(swappedIndex);
    }
  }

  private T leftChild(int i) {
    if (getLeftIndex(i) > heapList.size() - 1) {
      return null;
    }
    return heapList.get(getLeftIndex(i));
  }

  private T rightChild(int i) {
    if (getRightIndex(i) > (heapList.size() - 1)) {
      return null;
    }
    return heapList.get(getRightIndex(i));
  }

  private int getLeftIndex(int i) {
    return (i * 2) + 1;
  }

  private int getRightIndex(int i) {
    return (i * 2) + 2;
  }

  private int getParentIndex(int i) {
    return (i - 1) / 2;
  }
}
