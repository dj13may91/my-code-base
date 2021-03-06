package Skillenza;

import java.util.Scanner;
import java.util.StringTokenizer;

public class EmployeeSacking {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        while (testCases > 0) {
            testCases--;
            StringTokenizer data = new StringTokenizer(scan.nextLine(), " ");
            int E = Integer.parseInt(data.nextToken());
            int C = Integer.parseInt(data.nextToken());
            int D = Integer.parseInt(data.nextToken());
            String quitter[] = scan.nextLine().split(" ");
            int firedEmp = 0;
            while (E > 0) {
                E--;
                StringTokenizer employee = new StringTokenizer(scan.nextLine(), " ");
                int distance = 0;
                for (int i = 0; i < C; i++) {
                    if (!(quitter[i].equals(employee.nextToken())))
                        distance++;
                }
                if (distance <= D)
                    firedEmp++;
            }
            System.out.println(firedEmp);
        }
    }
}

/**
 * Employee SackingAn employer is suspicious of his employees! He thinks that there is a great likelihood that they are going to quit.
 * He decides to fire all those employees who are within D “distance” (where distance is defined below) of an employee A
 * who had quit recently. Call this number D the threshold distance.
 * The distance function Bd (P, Q) between two vectors P, Q of the same dimension is the number of positions
 * in which the corresponding components are different. Essentially it’s similar to the Hamming Distance!
 * Example:
 * Given two vectors P = (1,2,3) and Q = (4, 1, 3), Bd(P, Q) = 1 + 1 + 0 = 2 as the 1st and 2nd components of vector P
 * are different from the 1st and 2nd components in vector Q.
 * Each employee in the company is described by a vector with C components. Here each component is an integer.
 * Call this vector the characteristic vector.
 * Input format
 * The first line of input consists of the integer T. Then the first line of each test case consists of three integers E, C and D.
 * Here E is the number of employees in the company, C is the number of components of the vector characterizing each employee,
 * and D is the threshold distance as defined above. Then E + 1 lines follow with the input as follows:
 * E00 E01 … E0C
 * E10 E11 … E1C
 * …
 * EE0 EE1 … EEC
 * The characteristics vector of the employee A who quit is given by (E00, E01, … , E0C)
 * The characteristics vector of employee Ai is given by (Ei0, Ei1, …, EiC) where i ranges from 1 to E.
 * Overall each test case is as follows:
 * E C D
 * E00 E01 … E0C
 * E10 E11 … E1C
 * …
 * EE0 EE1 … EEC
 * Output format
 * The output is an integer Y that is the number of employees the employer is going to fire.
 * Essentially, the number of employees whose characteristics satisfy the equation:
 * Bd(A,Ai) <= D
 * Constraints
 * 1<= T <= 10000
 * 1 <= E <= 100000
 * 1 <= C <= 10000
 * 1 <= D <= ceil (C/50)
 * 1 <= Eij <= 10000000000
 * //
 * Sample Input:
 * 1
 * 5 3 1
 * 1 2 3
 * 4 1 2
 * 5 1 6
 * 1 5 9
 * 3 2 7
 * 7 2 3
 * O/p: 1
 * sample input 2:
 * 3
 * 66 8 3
 * 10 7 5 4 10 10 7 8
 * 4 7 8 3 7 9 10 10
 * 3 8 2 5 10 2 10 1
 * 3 3 8 10 9 8 9 8
 * 6 3 10 7 10 7 8 9
 * 9 1 10 5 3 6 6 7
 * 4 10 10 6 5 6 7 4
 * 1 10 8 7 8 8 6 7
 * 2 6 1 7 5 9 8 9
 * 10 1 4 2 9 6 4 6
 * 2 8 5 9 5 3 4 9
 * 1 2 5 2 1 3 2 8
 * 5 4 9 8 7 3 2 2
 * 6 10 5 8 4 4 2 9
 * 2 8 3 6 4 2 4 4
 * 7 9 7 4 1 2 10 1
 * 3 1 5 8 6 7 2 1
 * 5 7 2 1 9 9 7 6
 * 7 5 10 8 5 4 4 5
 * 10 4 1 10 7 10 9 6
 * 7 10 6 4 2 10 4 8
 * 9 6 9 9 9 2 2 2
 * 1 6 3 6 9 9 4 4
 * 3 10 7 1 3 10 3 3
 * 8 10 3 8 10 10 4 2
 * 4 9 7 9 7 7 4 8
 * 1 6 2 4 6 9 1 9
 * 2 9 6 8 1 3 4 10
 * 6 5 4 3 3 9 9 1
 * 3 7 3 2 3 1 9 3
 * 8 10 3 3 9 2 6 6
 * 4 6 4 8 2 4 4 10
 * 1 3 3 5 6 1 8 1
 * 9 1 5 4 8 4 10 6
 * 6 8 3 2 9 3 7 10
 * 6 7 10 2 3 2 4 5
 * 1 5 1 5 10 5 1 3
 * 1 4 4 6 5 5 7 3
 * 2 8 5 2 5 8 10 4
 * 3 10 5 5 6 8 9 5
 * 4 3 3 6 3 10 4 8
 * 3 1 8 9 5 7 9 3
 * 2 9 3 10 5 4 6 2
 * 10 2 3 4 7 10 6 4
 * 4 9 6 8 4 2 10 7
 * 6 9 4 7 8 2 10 3
 * 8 1 1 1 6 10 1 5
 * 5 2 1 2 4 9 9 3
 * 9 2 3 1 2 6 7 9
 * 5 6 5 5 3 1 9 2
 * 2 7 5 10 6 3 10 3
 * 6 4 9 10 4 1 8 6
 * 7 5 3 10 1 2 4 2
 * 4 10 1 6 8 8 5 3
 * 2 9 9 8 5 4 5 2
 * 2 5 4 9 1 3 9 4
 * 10 3 3 1 3 3 6 3
 * 6 6 8 3 6 10 1 1
 * 10 4 4 1 4 10 4 1
 * 2 2 1 7 5 8 5 8
 * 3 1 3 10 5 3 8 2
 * 3 5 8 1 4 7 10 8
 * 2 2 6 8 10 3 2 1
 * 9 7 2 4 7 9 4 4
 * 4 7 4 5 3 7 2 1
 * 8 1 4 7 9 5 2 10
 * 2 7 6 10 9 4 2 3
 * 81 3 2
 * 9 3 9
 * 6 8 3
 * 8 3 7
 * 2 1 6
 * 4 1 8
 * 2 8 1
 * 8 8 9
 * 8 7 6
 * 6 4 2
 * 8 8 7
 * 3 5 4
 * 2 8 7
 * 4 7 2
 * 8 1 5
 * 5 1 7
 * 10 2 6
 * 10 8 4
 * 8 2 5
 * 7 3 2
 * 4 9 7
 * 1 5 3
 * 2 9 7
 * 9 4 5
 * 9 5 10
 * 4 3 3
 * 4 9 2
 * 5 8 1
 * 10 4 4
 * 10 7 10
 * 3 1 1
 * 5 6 1
 * 7 3 6
 * 5 8 9
 * 7 7 3
 * 7 7 5
 * 3 7 1
 * 10 9 9
 * 9 1 2
 * 10 2 7
 * 4 6 4
 * 7 5 7
 * 2 5 9
 * 10 9 4
 * 2 1 10
 * 4 5 8
 * 4 10 8
 * 1 1 8
 * 6 4 4
 * 4 3 9
 * 2 1 1
 * 1 6 4
 * 6 7 6
 * 4 8 9
 * 5 5 2
 * 4 4 3
 * 4 1 5
 * 4 1 1
 * 4 3 6
 * 10 9 5
 * 1 6 5
 * 7 1 10
 * 7 2 1
 * 8 8 9
 * 4 8 1
 * 6 9 9
 * 4 9 10
 * 6 4 9
 * 6 9 2
 * 7 5 6
 * 1 8 3
 * 5 3 3
 * 7 2 8
 * 10 9 1
 * 9 4 9
 * 2 8 4
 * 6 8 7
 * 3 9 8
 * 1 8 10
 * 3 4 3
 * 1 4 4
 * 2 4 5
 * 2 3 3
 * 64 8 1
 * 6 8 6 9 1 4 2 7
 * 10 3 7 9 5 2 6 8
 * 2 10 3 8 10 2 3 2
 * 5 1 4 9 4 2 6 5
 * 5 2 8 9 6 6 3 5
 * 7 5 7 3 3 4 9 3
 * 5 2 8 6 5 4 5 5
 * 5 6 9 4 4 10 9 8
 * 10 10 8 1 5 9 1 8
 * 1 4 8 4 8 6 5 6
 * 2 9 3 9 7 2 9 1
 * 8 9 7 1 3 10 9 8
 * 4 8 4 7 6 4 6 5
 * 6 5 2 9 9 2 3 7
 * 6 8 5 9 6 7 5 9
 * 10 4 1 4 1 8 7 5
 * 8 8 8 9 1 9 9 1
 * 5 1 4 9 10 4 9 10
 * 5 4 5 2 8 2 10 1
 * 7 7 2 10 7 10 6 10
 * 4 8 5 7 4 3 1 9
 * 4 7 3 5 9 4 6 7
 * 10 8 6 1 6 1 6 8
 * 9 4 3 3 6 6 10 8
 * 3 5 1 5 3 5 6 4
 * 4 2 7 9 7 5 2 6
 * 3 4 8 6 7 3 8 8
 * 2 3 9 9 5 1 3 6
 * 7 9 2 2 4 5 1 5
 * 4 3 7 3 5 7 2 2
 * 2 7 7 8 3 4 1 7
 * 3 7 3 3 3 6 7 9
 * 8 8 3 7 9 4 2 5
 * 4 6 6 9 4 10 1 2
 * 10 9 3 6 1 4 8 8
 * 8 8 5 3 8 7 10 7
 * 8 3 2 7 10 1 1 3
 * 10 6 1 10 3 1 9 8
 * 7 9 6 3 8 10 1 5
 * 2 2 3 4 4 3 1 10
 * 2 3 5 7 7 9 5 6
 * 6 1 3 6 9 6 4 1
 * 7 3 3 10 10 4 8 3
 * 2 3 2 8 2 1 10 2
 * 8 1 1 1 10 9 6 10
 * 9 8 4 8 5 4 3 6
 * 7 4 8 1 6 1 2 9
 * 9 5 5 10 1 3 4 7
 * 5 8 3 3 8 2 8 6
 * 5 4 5 9 6 5 6 2
 * 5 6 1 4 7 10 7 9
 * 2 9 10 5 2 7 9 9
 * 6 3 4 7 10 1 2 6
 * 5 10 7 4 3 10 9 5
 * 9 5 10 2 3 8 5 4
 * 2 9 10 7 9 10 3 6
 * 3 10 1 8 4 5 1 9
 * 2 8 9 10 1 10 7 5
 * 1 1 10 4 7 1 1 5
 * 3 4 6 4 7 9 6 8
 * 10 2 8 6 4 5 10 1
 * 4 1 8 1 3 8 1 3
 * 4 10 8 6 1 9 7 8
 * 1 2 4 5 8 3 5 4
 * 5 1 4 10 4 1 8 8
 * O/p:
 * 0
 * 20
 * 0
 */