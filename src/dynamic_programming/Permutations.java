package dynamic_programming;

import java.util.HashSet;
import java.util.Set;

public class Permutations {

  public static Set<String> words = new HashSet<>();

  public static void main(String[] args) {
    String word = "abc";
    combinations(word, 0);
//    System.out.println(words.size() + " - " + words);
  }

  public static void combinations(String word, int fixedIndex) {
    if (fixedIndex == word.length() - 1) {
      System.out.println(word);
      return;
    }
    for (int i = fixedIndex; i < word.length(); i++) {
      char[] currWord = word.toCharArray();
      char temp = currWord[i];
      currWord[i] = currWord[fixedIndex];
      currWord[fixedIndex] = temp;
      words.add(String.valueOf(currWord));
      combinations(String.valueOf(currWord), fixedIndex + 1);
    }
  }
}
