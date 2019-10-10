package shared;

import java.util.ArrayList;
import java.util.List;

public class Person {

  private String name;
  private int age;
  private char sex;
  private String mother;
  private String father;
  private String spouse;
  private List<String> kids = new ArrayList<>();

  public Person() {
  }

  public Person(String name, int age, char sex, String mother, String father, String spouse) {
    this.name = name;
    this.age = age;
    this.sex = sex;
    this.mother = mother;
    this.father = father;
    this.spouse = spouse;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public char getSex() {
    return sex;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }

  public String getMother() {
    return mother;
  }

  public void setMother(String mother) {
    this.mother = mother;
  }

  public String getFather() {
    return father;
  }

  public void setFather(String father) {
    this.father = father;
  }

  public List<String> getKids() {
    return kids;
  }

  public void setKids(List<String> kids) {
    this.kids = kids;
  }

  public String getSpouse() {
    return spouse;
  }

  public void setSpouse(String spouse) {
    this.spouse = spouse;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", sex=" + sex +
        ", mother='" + mother + '\'' +
        ", father='" + father + '\'' +
        ", spouse='" + spouse + '\'' +
        ", kids=" + kids +
        '}';
  }
}
