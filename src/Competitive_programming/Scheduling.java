/**
 * Andy studies at the University of California is very studious. He wants to take as many subjects as possible without any class overlap.
 * The University doesn’t impose any restriction of the number of classes taken during the semester.
 * He really doesn’t care about what subject he takes; he likes them all! However, he wants to maximize the number of subjects he can take.
 * Input Format:
 * The first line of input consists of an integer t. This is the number of days.
 * For each day, the first line contains an integer n which gives the number of subjects offered on that day.
 * Then next n lines follow containing the subject name (which is a string) followed by start and end time for that subject in 24 hour format: hh:mm
 * * Maths 10:00 11:00
 * * Note: The timings are given in 24-hour format and the subject names do not have spaces between them.
 * * Output Format
 * * The output should contain t lines and each line has a number representing the maximum number of classes Andy can chose.
 * * Constraints
 * * 1 <= t <= 5000
 * 2 <= n <= 100
 * start time of a class < end time of class
 * Sample Input
 * 2
 * 4
 * Maths 16:00 18:00
 * ComputerScience 12:00 13:00
 * Physics 12:30 14:00
 * Chemistry 14:00 16:30
 * 5
 * Geography 14:00 16:00
 * History 12:00 14:30
 * Arts 14:00 16:30
 * Literature 12:30 13:30
 * German 13:30 15:00
 *
 * Sample Output
 * 2
 * Explanation for 2nd input
 * * For the 1st day, ComputerScience starts the earliest and ends the earliest, so we take it first. After the we cannot take Physics because it starts before
 * ComputerScience is over. So we will take the next class, that is, Chemistry. But after Chemistry we cannot take Maths as Maths class starts before Chemistry class ends.
 * So we can schedule a maximum of 2 classes for the first day.
 * * Similarly we schedule for the second day.
 */

package Competitive_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class SubjectDetails implements Comparable<SubjectDetails> {
    public String subjectName;
    public String startTime;
    public String endTime;
    public int startHour;
    public int startMin;
    public int endHour;
    public int endMin;

    public SubjectDetails(String subjectName, String startTime, String endTime) {
        this.subjectName = subjectName;
        this.startTime = startTime;
        this.startHour = Integer.parseInt(startTime.split(":")[0]);
        this.startMin = Integer.parseInt(startTime.split(":")[1]);

        this.endTime = endTime;
        this.endHour = Integer.parseInt(endTime.split(":")[0]);
        this.endMin = Integer.parseInt(endTime.split(":")[1]);
    }

    @Override
    public int compareTo(SubjectDetails o) {
        if (this.startHour == o.startHour) {
            if (this.startMin == o.startMin) {
                if (this.endHour == o.endHour) {
                    return this.endMin - o.endMin;
                }
                return this.endHour - o.endHour;
            }
            return this.startMin - o.startMin;
        }
        return this.startHour - o.startHour;
    }
}

public class Scheduling {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = readNextInt();
        for (int i = 0; i < testCases; i++) {
            int subjectCount = readNextInt();
            List<SubjectDetails> detailsList = new ArrayList<>();
            for (int j = 0; j < subjectCount; j++) {
                String currentSubject[] = readNextLine();
                detailsList.add(new SubjectDetails(currentSubject[0], currentSubject[1], currentSubject[2]));
            }
            Collections.sort(detailsList);
            int max = 0;
            for (int j = 0; j < subjectCount; j++) {
//                System.out.println("call " + j + " for: " + detailsList.get(j));
                int currMax = getMaxCount(detailsList, j);
//                System.out.println("------------------------------------------------------------------------------------");
                max = currMax > max ? currMax : max;
            }
            System.out.println(max + 1);
            System.out.println(detailsList);
        }
    }

    private static int getMaxCount(List<SubjectDetails> list, int currentIndex) {
        if (currentIndex > list.size() - 1)
            return 0;
        SubjectDetails currSubject = list.get(currentIndex);
        final int[] max = {0};
        if (currentIndex < list.size() - 1) {
            list.subList(currentIndex + 1, list.size() - 1).parallelStream().forEach((item) -> {
                SubjectDetails nextSubject = item;
                int currMax = 0;
                if (currSubject.endHour < nextSubject.startHour) {
//                System.out.println("calling next for: " + nextSubject);
                    currMax++;
                    currMax = currMax + getMaxCount(list, list.indexOf(item));
                } else if (currSubject.endHour == nextSubject.startHour) {
                    if (currSubject.endMin <= nextSubject.startMin) {
//                    System.out.println("calling next for: " + nextSubject);
                        currMax++;
                        currMax = currMax + getMaxCount(list, list.indexOf(item));
                    }
                }
                max[0] = currMax > max[0] ? currMax : max[0];
            });
        }
//        System.out.println("return max as " + max);
        return max[0];
    }

    private static int readNextInt() {
        return Integer.parseInt(scan.nextLine());
    }

    private static String[] readNextLine() {
        return scan.nextLine().split(" ");
    }
}


/**
 * Competitive_programming.Scheduling Classes
 * Andy studies at the University of California is very studious. He wants to take as many subjects as possible without any class overlap.
 * The University doesn’t impose any restriction of the number of classes taken during the semester.
 * * He really doesn’t care about what subject he takes; he likes them all! However, he wants to maximize the number of subjects he can take.
 * * Input Format
 * * The first line of input consists of an integer t. This is the number of days.
 * For each day, the first line contains an integer n which gives the number of subjects offered on that day.
 * Then next n lines follow containing the subject name (which is a string) followed by start and end time for that subject in 24 hour format: hh:mm
 * * Maths 10:00 11:00
 * * Note: The timings are given in 24-hour format and the subject names do not have spaces between them.
 * * Output Format
 * * The output should contain t lines and each line has a number representing the maximum number of classes Andy can chose.
 * * Constraints
 * * 1 <= t <= 5000
 * 2 <= n <= 100
 * start time of a class < end time of class
 * Sample Input
 * * 2
 * 4
 * Maths 16:00 18:00
 * ComputerScience 12:00 13:00
 * Physics 12:30 14:00
 * Chemistry 14:00 16:30
 * 5
 * Geography 14:00 16:00
 * History 12:00 14:30
 * Arts 14:00 16:30
 * Literature 12:30 13:30
 * German 13:30 15:00
 * Sample Output
 * * 2
 * 2
 * Explanation
 * * For the 1st day, ComputerScience starts the earliest and ends the earliest, so we take it first. After the we cannot take Physics because it starts before
 * ComputerScience is over. So we will take the next class, that is, Chemistry. But after Chemistry we cannot take Maths as Maths class starts before Chemistry class ends.
 * So we can schedule a maximum of 2 classes for the first day.
 * * Similarly we schedule for the second day.
 */
