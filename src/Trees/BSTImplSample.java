package Trees;

import java.util.Comparator;

class Employee {
    int age;
    int salary;

    public Employee(int age, int salary) {
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee {" + "age=" + age + ", salary=" + salary + "}";
    }
}

public class BSTImplSample {

    public static void main(String[] args) {
        CompareNodes compareNodes = new CompareNodes();
        BinaryTree<Employee> tree = new BinaryTree<>(true, compareNodes);
        int nodes = 1;
        while (nodes++ <= 7)
            tree.add(new Employee(((int) (Math.random() * 100)), ((int) (Math.random() * 100000))));

        tree.inorderTraversal(tree.getRoot());
        System.out.println();
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
 * //  Setting root value as: Employee{age=96, salary=49143}
 * //
 * //  adding [Employee{age=15, salary=27512}] to left of parent [Employee{age=96, salary=49143}]
 * //  Going left of tree with current parent as [Employee{age=96, salary=49143}] for node [Employee{age=54, salary=22887}]
 * //  adding [Employee{age=54, salary=22887}] to right of parent [Employee{age=15, salary=27512}]
 * //  Going left of tree with current parent as [Employee{age=96, salary=49143}] for node [Employee{age=73, salary=2331}]
 * //  Going right of tree with current parent as [Employee{age=15, salary=27512}] for node [Employee{age=73, salary=2331}]
 * //  adding [Employee{age=73, salary=2331}] to right of parent [Employee{age=54, salary=22887}]
 * //  Going left of tree with current parent as [Employee{age=96, salary=49143}] for node [Employee{age=79, salary=13219}]
 * //  Going right of tree with current parent as [Employee{age=15, salary=27512}] for node [Employee{age=79, salary=13219}]
 * //  Going right of tree with current parent as [Employee{age=54, salary=22887}] for node [Employee{age=79, salary=13219}]
 * //  adding [Employee{age=79, salary=13219}] to right of parent [Employee{age=73, salary=2331}]
 * //  Going left of tree with current parent as [Employee{age=96, salary=49143}] for node [Employee{age=58, salary=27678}]
 * //  Going right of tree with current parent as [Employee{age=15, salary=27512}] for node [Employee{age=58, salary=27678}]
 * //  Going right of tree with current parent as [Employee{age=54, salary=22887}] for node [Employee{age=58, salary=27678}]
 * //  adding [Employee{age=58, salary=27678}] to left of parent [Employee{age=73, salary=2331}]
 * //  Going left of tree with current parent as [Employee{age=96, salary=49143}] for node [Employee{age=90, salary=65536}]
 * //  Going right of tree with current parent as [Employee{age=15, salary=27512}] for node [Employee{age=90, salary=65536}]
 * //  Going right of tree with current parent as [Employee{age=54, salary=22887}] for node [Employee{age=90, salary=65536}]
 * //  Going right of tree with current parent as [Employee{age=73, salary=2331}] for node [Employee{age=90, salary=65536}]
 * //  adding [Employee{age=90, salary=65536}] to right of parent [Employee{age=79, salary=13219}]
 * //
 * //  Inorder traversal:
 * //  Employee{age=15, salary=27512}
 * //  Employee{age=54, salary=22887}
 * //  Employee{age=58, salary=27678}
 * //  Employee{age=73, salary=2331}
 * //  Employee{age=79, salary=13219}
 * //  Employee{age=90, salary=65536}
 * //  Employee{age=96, salary=49143}
 */