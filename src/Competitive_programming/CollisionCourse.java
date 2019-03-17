package Competitive_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollisionCourse {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int objectCount = Integer.parseInt(scan.nextLine());
        List<Integer> objectSpeeds = new ArrayList<>();
        int collisionCount = 0;
        while(objectCount > 0) {
            objectSpeeds.add(Integer.parseInt(scan.nextLine()));
            objectCount--;
        }

        int particleToMonitor = Integer.parseInt(scan.nextLine());
        for(int i =0; i< particleToMonitor; i++) {
            if(objectSpeeds.get(i) > particleToMonitor){
                collisionCount++;
            }
        }

        for(int i =particleToMonitor; i< objectSpeeds.size(); i++) {
            if(objectSpeeds.get(i) < particleToMonitor){
                collisionCount++;
            }
        }
        System.out.println(collisionCount);
    }
}

/**
8
6
6
1
6
3
4
6
8
2


10
8
3
6
3
2
2
4
8
1
6
7
 */
