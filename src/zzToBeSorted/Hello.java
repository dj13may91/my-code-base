package zzToBeSorted;

import java.util.*;

/*
  Suppose we have some input data describing a graph of relationships between parents and children over multiple families and generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.

  For example, in this diagram, 3 is a child of 1 and 2, and 5 is a child of 4:

1   2    4           30
 \ /   /  \           \
  3   5    9  15      16
   \ / \    \ /
    6   7   12


  Sample input/output (pseudo data):

  pairs = [
      (5, 6), (1, 3), (2, 3), (3, 6), (15, 12),
      (5, 7), (4, 5), (4, 9), (9, 12), (30, 16)
  ]
[parent, child]

  Write a function that takes this data as input and returns two collections: one containing all individuals with zero known parents, and one containing all individuals with exactly one known parent.


  Output may be in any order:

  findNodesWithZeroAndOneParents(pairs) => [
    [1, 2, 4, 15, 30],   // Individuals with zero parents
    [5, 7, 9, 16]        // Individuals with exactly one parent
  ]

  Complexity Analysis variables:

  n: number of pairs in the input
*/

import java.io.*;
import java.util.*;

public class Hello {
    public static void main(String[] argv) {
        int[][] pairs = new int[][]{
                {5, 6}, {1, 3}, {2, 3}, {3, 6}, {15, 12}, {5, 7},
                {4, 5}, {4, 9}, {9, 12}, {30, 16}
        };
        System.out.println(checkParentCount(pairs));
    }

    public static Set<Set<Integer>> checkParentCount(int[][] pairs) {
        Set<Integer> zero = new HashSet<Integer>();
        Set<Integer> one = new HashSet<Integer>();
        Set<Set<Integer>> response = new HashSet<>();
        Set<Integer> discarded = new HashSet<>();

        if (pairs.length == 0) {
            System.out.println("zero pairs found");
            return response;
        }

        if (pairs.length == 1) {
            System.out.println("one pair found");
            zero.add(pairs[0][0]);
            one.add(pairs[0][1]);
            response.add(zero);
            response.add(one);
            return response;
        }
        for (int[] pair : pairs) {
            int parent = pair[0];
            int child = pair[1];
            System.out.println("current: " + Arrays.toString(pair) + "; zero : " + zero + "; one: " + one + "; discarded: " + discarded);
            if (!discarded.contains(parent)) {
                if (!one.contains(parent)) {
                    if (!zero.contains(parent)) {
                        System.out.println("0+ : " + parent);
                        zero.add(parent);
                    }
                }
            }

            if (!discarded.contains(child)) {
                if (!one.contains(child)) {
                    one.add(child);
                    zero.remove(child);
                    System.out.println("1+ , 0- : " + child);
                } else {
                    one.remove(child);
                    discarded.add(child);
                    System.out.println("1- , 2+ : " + child);
                }
            }
        }
        response.add(zero);
        response.add(one);
        return response;
    }
}



