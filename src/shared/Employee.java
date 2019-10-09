package shared;

public class Employee {
  public int id;
  public int age;
  public int salary;

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
