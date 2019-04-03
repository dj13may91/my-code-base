package Skillenza;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String rollNumber;
    private String regDate;
    private String regTime;
    private String name;
    private String gender;

    public Student(String rollNumber, String regDate, String regTime, String name, String gender) {
        this.rollNumber = rollNumber;
        this.regDate = regDate;
        this.regTime = regTime;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return rollNumber + ' ' + name + ' ' + gender + ' ' + regDate;
    }
}

public class PaymentSolution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        Map<String, Student> studentMap = new LinkedHashMap<>();
        while (testCases > 0) {
            testCases--;
            String data[] = scan.nextLine().split(",");
            Student student = new Student(data[0], data[1], data[2], data[3], data[4]);
            studentMap.put(data[0], student);
        }

        int paymentsMade = Integer.parseInt(scan.nextLine());
        while (paymentsMade > 0) {
            paymentsMade--;
            studentMap.remove(scan.nextLine().split(",")[0]);
        }

        studentMap.forEach((k, v) -> System.out.println(v));
    }
}
