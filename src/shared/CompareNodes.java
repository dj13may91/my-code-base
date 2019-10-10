package shared;

import java.util.Comparator;

public class CompareNodes implements Comparator<Employee> {

  @Override
  public int compare(Employee o1, Employee o2) {
    if (o1 == o2) {
      return 0;
    }
    if (o1 == null) {
      System.out.println("o1 null");
      return -1;
    }
    if (o2 == null) {
      System.out.println("o2 null");
      return 1;
    }
    if (o1.age == o2.age) {
      return o1.salary - o2.salary;
    } else {
      return o1.age - o2.age;
    }
  }
}
