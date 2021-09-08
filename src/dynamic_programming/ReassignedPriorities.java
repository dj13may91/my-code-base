package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ReassignedPriorities {

  public static void main(String[] args) {
    System.out.println(reassignedPriorities(Arrays.asList(2,3,5,2,8)));
  }

  public static List<Integer> reassignedPriorities(List<Integer> priorities) {
    // Write your code here
    Map<Integer, Integer> map = new HashMap<>();
    for(int i : priorities){
      map.put(i,i);
    }
    List<Integer> result = new ArrayList<>(map.keySet());
    Collections.sort(result);
    int priority = 1;
    for(int i=0; i<result.size(); i++) {
      map.put(result.get(i), priority);
      priority++;
    }

    for(int i=0; i<priorities.size(); i++) {
      priorities.set(i, map.get(priorities.get(i)));
    }
//    Collections.sort();
    return priorities;
  }

}
