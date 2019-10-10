package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import shared.CompareNodes;
import shared.Employee;

public class MaxHeapImplSample {

  public static void main(String[] args) {
    List<Employee> employeeList = new ArrayList<>();
    int nodes = 0;
    while (nodes++ <= 7) {
      employeeList.add(
          new Employee(nodes, ((int) (Math.random() * 100)), ((int) (Math.random() * 100000))));
    }
    System.out.println("Before maxheap");
    System.out.println(employeeList);
    System.out.println(employeeList.parallelStream().map(e -> e.age).collect(Collectors.toList()));
    MaxHeap<Employee> heap = new MaxHeap<>(employeeList, new CompareNodes());

    System.out.println("After maxheap");
    System.out.println(employeeList);
    System.out.println(employeeList.parallelStream().map(e -> e.age).collect(Collectors.toList()));
  }
}


/*
Output:
Before maxheap
[Employee{id=1, age=36, salary=34602},Employee{id=2, age=79, salary=84523},
 Employee{id=3, age=88, salary=62099}, Employee{id=4, age=57, salary=73431},
 Employee{id=5, age=95, salary=25622}, Employee{id=6, age=94, salary=96232},
 Employee{id=7, age=71, salary=67327}, Employee{id=8, age=51, salary=26010}]
[36, 79, 88, 57, 95, 94, 71, 51]
After maxheap
[Employee{id=5, age=95, salary=25622}, Employee{id=2, age=79, salary=84523},
 Employee{id=6, age=94, salary=96232}, Employee{id=4, age=57, salary=73431},
 Employee{id=1, age=36, salary=34602}, Employee{id=3, age=88, salary=62099},
 Employee{id=7, age=71, salary=67327}, Employee{id=8, age=51, salary=26010}]
[95, 79, 94, 57, 36, 88, 71, 51]

 */
