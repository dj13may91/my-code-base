package Competitive_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import shared.Person;

public class FamilyTree {

  private Map<String, Person> familyTreeMap = new HashMap<>();

  public static void main(String[] args) {
    FamilyTree familyTree = new FamilyTree();
    List<Person> people = new ArrayList<Person>() {{
      add(new Person("ken", 28, 'm', "laura", "bridget", "shauna"));
      add(new Person("shauna", 26, 'f', "mary", "jones", "ken"));
      add(new Person("ben", 4, 'm', "shauna", "ken", null));
      add(new Person("shirley", 2, 'f', "shauna", "ken", null));
      add(new Person("laura", 52, 'f', "leena", "leonard", "bridget"));
      add(new Person("bridget", 56, 'm', "donna", "donald", "laura"));
      add(new Person("tom", 68, 'm', "donna", "donald", null));
      add(new Person("britney", 34, 'f', "laura", "bridget", "boris"));
      add(new Person("keanu", 22, 'm', "laura", "bridget", null));
      add(new Person("boris", 36, 'm', "lisa", "ray", null));
      add(new Person("charlie", 10, 'm', "britney", "boris", null));
      add(new Person("donald", 110, 'm', null, null, "donna"));
      add(new Person("donna", 86, 'f', null, null, "donald"));
    }};

    people.forEach(familyTree::updateTree);
    familyTree.familyTreeMap.keySet()
        .forEach(s -> System.out.println(familyTree.familyTreeMap.get(s)));

    familyTree.printInLaws("ken");
  }

  private void updateTree(Person person) {
    familyTreeMap.put(person.getName(), person);
    if (person.getFather() != null) {
      updatePersonRelationship(person, person.getFather());
    }
    if (person.getMother() != null) {
      updatePersonRelationship(person, person.getMother());
    }
  }

  private void updatePersonRelationship(Person person, String parentName) {
    Person parent = familyTreeMap.get(parentName);
    if (parent == null) {
      parent = new Person();
      parent.setName(parentName);
    }
    parent.getKids().add(person.getName());
    familyTreeMap.put(parent.getName(), parent);
  }

  private void printInLaws(String personName){
    Person spouse = familyTreeMap.get(personName);
    List<String> inLawListFather = familyTreeMap.get(
        spouse.getFather()
    ).getKids();

    List<String> inLawListMother = familyTreeMap.get(
        spouse.getMother()
    ).getKids();

    Set<String> inLawIntersection = new HashSet<>();
    inLawIntersection.addAll(inLawListFather);
    inLawIntersection.addAll(inLawListMother);

    System.out.println("In laws: " + inLawIntersection);
  }


}

/**
 Output:
 Person{name='donald', age=110, sex=m, mother='null', father='null', spouse='donna', kids=[]}
 Person{name='shirley', age=2, sex=f, mother='shauna', father='ken', spouse='null', kids=[]}
 Person{name='donna', age=86, sex=f, mother='null', father='null', spouse='donald', kids=[]}
 Person{name='mary', age=0, sex= , mother='null', father='null', spouse='null', kids=[shauna]}
 Person{name='bridget', age=56, sex=m, mother='donna', father='donald', spouse='laura', kids=[britney, keanu]}
 Person{name='ben', age=4, sex=m, mother='shauna', father='ken', spouse='null', kids=[]}
 Person{name='ray', age=0, sex= , mother='null', father='null', spouse='null', kids=[boris]}
 Person{name='britney', age=34, sex=f, mother='laura', father='bridget', spouse='boris', kids=[charlie]}
 Person{name='laura', age=52, sex=f, mother='leena', father='leonard', spouse='bridget', kids=[britney, keanu]}
 Person{name='leonard', age=0, sex= , mother='null', father='null', spouse='null', kids=[laura]}
 Person{name='tom', age=68, sex=m, mother='donna', father='donald', spouse='null', kids=[]}
 Person{name='ken', age=28, sex=m, mother='laura', father='bridget', spouse='shauna', kids=[ben, shirley]}
 Person{name='boris', age=36, sex=m, mother='lisa', father='ray', spouse='null', kids=[charlie]}
 Person{name='shauna', age=26, sex=f, mother='mary', father='jones', spouse='ken', kids=[ben, shirley]}
 Person{name='lisa', age=0, sex= , mother='null', father='null', spouse='null', kids=[boris]}
 Person{name='keanu', age=22, sex=m, mother='laura', father='bridget', spouse='null', kids=[]}
 Person{name='jones', age=0, sex= , mother='null', father='null', spouse='null', kids=[shauna]}
 Person{name='leena', age=0, sex= , mother='null', father='null', spouse='null', kids=[laura]}
 Person{name='charlie', age=10, sex=m, mother='britney', father='boris', spouse='null', kids=[]}

 In laws : [keanu, britney]
*/
