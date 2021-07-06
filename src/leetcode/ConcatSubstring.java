package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//You are given a string s and an array of strings words of the same length.
// Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once,
// in any order, and without any intervening characters.
//
//You can return the answer in any order.
// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

public class ConcatSubstring {

  public static void main(String[] args) {
    String s = "wordgoodgoodgoodbestword";
    String[] words = {"word","good","best","good"};
    System.out.println(findSubstring(s, words));
  }

  public static List<Integer> findSubstring(String s, String[] words) {
    List<Integer> posList = new ArrayList<>();
    int len = s.length();
    int subStrLength = words[0].length() * words.length; //since each word of same length
    if (subStrLength > len) {
      return posList;
    }
    Map<String, Integer> frequencyMap = new HashMap<>();
    for (String word : words) {
      frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
    }
    int currPos;
    for (int i = 0; i < len - subStrLength + 1; i++) {
      currPos = i;
      Map<String, Integer> currFrequencyMap = new HashMap<>();
      boolean found = true;
      for (int j = 0; j < words.length; j++) {
        String currStr = s.substring(currPos, words[0].length() + currPos);
        if (frequencyMap.get(currStr) == null) {
          found = false;
          break;
        } else {
          currFrequencyMap.put(currStr, currFrequencyMap.getOrDefault(currStr, 0) + 1);
          currPos = currPos + words[0].length();
        }
        if (currFrequencyMap.get(currStr) > frequencyMap.get(currStr)) {
          found = false;
          break;
        }
      }
      if (found) {
        posList.add(i);
      }
    }
    return posList;
  }
}
