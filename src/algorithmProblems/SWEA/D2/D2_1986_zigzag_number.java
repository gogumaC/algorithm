package SWEA.D2;

import java.util.Scanner;

public class D2_1986_zigzag_number {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int sum = 0;
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 1) sum += i;
                else sum -= i;
            }
            System.out.println("#" + test_case + " " + sum);


        }
    }
}
