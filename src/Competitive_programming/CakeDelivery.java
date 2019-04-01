/**
 * A cake factory makes various different varieties of cakes. It is the largest factory in the state
 * and takes orders from different places to prepare and deliver cakes.
 * The cake factory has a very large number of employees but not all employees come for work everyday.
 * Due to this, some days the cake factory can make a large delivery while on other days,
 * they may be able to deliver only a handful of cakes.
 * The factory produces M number of cakes each day and all cakes weigh differently.
 * Every morning, the manager gets an order to deliver N kgs of cake.
 * The factory can either completely deliver the order or not deliver the order at all.
 * Help the manager of the cake factory to determine whether can be delivered for the day or not.
 * Note: The cakes produced by the factory have to be delivered as a whole; they cannot be cut into pieces.
 * Constraints: 1 <= T <= 400, 1 <= M <= 1000, 1 <= weight of each cake <= 1000, 1 <= N <= 10000
 * Sample Input Format:
 * First line contains T which indicates the number of days for which the delivery is to be made.
 * Second line contains M + 1 space separated integers in which the first integer denotes the number of cakes to be made in one day
 * and the following M integers denote the weight of each cake.
 * Third line contains N which indicates the weight of cake in kgs which needs to delivered.
 * Sample Output Format:
 * Output YES if the delivery for that day can be made, otherwise NO for each test case.
 * Sample Input
 * 3
 * 4 12 2 15 9
 * 11
 * 7 20 13 5 8 2 11 3
 * 23
 * 3 7 4 1
 * 6
 * Sample Output
 * YES
 * YES
 * NO
 * Explanation
 * In the first case, the cake factory produces 4 cakes in a day.The weight of each cake is 12 kg, 2 kg, 15 kg, 9 kg respectively.
 * The order received for cake delivery is 11 kg. If the cake factory delivers 2 kg and 9 kg cake,
 * then the total order would be equal to 11 kg. Therefore, the delivery for this day can be made successfully.
 */
package Competitive_programming;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CakeDelivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        List<DeliveryOperations> operationsList = new LinkedList<>();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            String cakeOrders[] = scanner.nextLine().split(" ");
            DeliveryOperations operations = new DeliveryOperations();
            operations.numberOfCakes = Integer.parseInt(cakeOrders[0]);
            operations.cakes = new int[operations.numberOfCakes];
            while (operations.numberOfCakes > 0) {
                operations.numberOfCakes--;
                operations.cakes[operations.numberOfCakes] = Integer.parseInt(cakeOrders[operations.numberOfCakes + 1]);
            }
            operations.cakeWeightToDeliver = Integer.parseInt(scanner.nextLine());
            operationsList.add(operations);
            Thread t = new Thread(operations);
            threadList.add(t);
            t.start();
        }

        try {
            for (Thread t : threadList) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < operationsList.size(); i++) {
            if (operationsList.get(i).flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}

class DeliveryOperations implements Runnable {

    public int numberOfCakes;
    public int cakeWeightToDeliver;
    int cakes[];
    boolean flag = false;

    @Override
    public void run() {
        Arrays.parallelSort(cakes);
        long possibleWightCombinations = (long) Math.pow(2, cakes.length) - 1;
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        while (possibleWightCombinations >= 1) {
            final int[] sum = {0};
            long finalPossibleWightCombinations = possibleWightCombinations;
            Runnable r = () -> {
                for (int j = 0; j < cakes.length; j++) {
                    if (BigInteger.valueOf(finalPossibleWightCombinations).testBit(j))
                        sum[0] = sum[0] + cakes[j];
                }
                map.put(sum[0], sum[0]);
            };
            Thread t = new Thread(r);
            t.run();
            t.interrupt();
            if (map.get(cakeWeightToDeliver) != null) {
                flag = true;
                return;
            }
            possibleWightCombinations--;
        }
        if (map.get(cakeWeightToDeliver) != null) {
            flag = true;
        }
    }
}