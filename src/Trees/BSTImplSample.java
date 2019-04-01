package Trees;

import java.util.Comparator;

class Employee {
    int id;
    int age;
    int salary;

    public Employee(int id, int age, int salary) {
        this.id = id;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

public class BSTImplSample {

    public static void main(String[] args) {
        CompareNodes compareNodes = new CompareNodes();
        BinaryTree<Employee> tree = new BinaryTree<>(true, compareNodes);
        int nodes = 0;
        while (nodes++ <= 7)
            tree.add(new Employee(nodes, ((int) (Math.random() * 100)), ((int) (Math.random() * 100000))));

        tree.inorderTraversal(tree.getRoot());
        System.out.println();
        System.out.println("height of tree: " + tree.heightOfTree());

    }
}

class CompareNodes implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.age == o2.age)
            return o1.salary - o2.salary;
        else
            return o1.age - o2.age;
    }
}


/**
 * Setting root value as: Employee{id=1, age=4, salary=9732}
 * //
 * adding [Employee{id=2, age=35, salary=15338}] to right of parent [Employee{id=1, age=4, salary=9732}]
 * Going right of tree with current parent as [Employee{id=1, age=4, salary=9732}] for node [Employee{id=3, age=75, salary=74685}]
 * adding [Employee{id=3, age=75, salary=74685}] to right of parent [Employee{id=2, age=35, salary=15338}]
 * Going right of tree with current parent as [Employee{id=1, age=4, salary=9732}] for node [Employee{id=4, age=69, salary=41094}]
 * Going right of tree with current parent as [Employee{id=2, age=35, salary=15338}] for node [Employee{id=4, age=69, salary=41094}]
 * adding [Employee{id=4, age=69, salary=41094}] to left of parent [Employee{id=3, age=75, salary=74685}]
 * Going right of tree with current parent as [Employee{id=1, age=4, salary=9732}] for node [Employee{id=5, age=22, salary=17793}]
 * adding [Employee{id=5, age=22, salary=17793}] to left of parent [Employee{id=2, age=35, salary=15338}]
 * adding [Employee{id=6, age=1, salary=96857}] to left of parent [Employee{id=1, age=4, salary=9732}]
 * Going right of tree with current parent as [Employee{id=1, age=4, salary=9732}] for node [Employee{id=7, age=59, salary=63524}]
 * Going right of tree with current parent as [Employee{id=2, age=35, salary=15338}] for node [Employee{id=7, age=59, salary=63524}]
 * Going left of tree with current parent as [Employee{id=3, age=75, salary=74685}] for node [Employee{id=7, age=59, salary=63524}]
 * adding [Employee{id=7, age=59, salary=63524}] to left of parent [Employee{id=4, age=69, salary=41094}]
 * Going right of tree with current parent as [Employee{id=1, age=4, salary=9732}] for node [Employee{id=8, age=39, salary=17785}]
 * Going right of tree with current parent as [Employee{id=2, age=35, salary=15338}] for node [Employee{id=8, age=39, salary=17785}]
 * Going left of tree with current parent as [Employee{id=3, age=75, salary=74685}] for node [Employee{id=8, age=39, salary=17785}]
 * Going left of tree with current parent as [Employee{id=4, age=69, salary=41094}] for node [Employee{id=8, age=39, salary=17785}]
 * adding [Employee{id=8, age=39, salary=17785}] to left of parent [Employee{id=7, age=59, salary=63524}]
 * //
 * Employee{id=6, age=1, salary=96857} Employee{id=1, age=4, salary=9732} Employee{id=5, age=22, salary=17793} Employee{id=2, age=35, salary=15338} Employee{id=8, age=39, salary=17785} Employee{id=7, age=59, salary=63524} Employee{id=4, age=69, salary=41094} Employee{id=3, age=75, salary=74685}
 * height of tree: 5
 */