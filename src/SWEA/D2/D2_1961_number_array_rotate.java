package SWEA.D2;

import java.util.Scanner;

public class D2_1961_number_array_rotate {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int[][] matrix90 = new int[n][n];
            int[][] matrix180 = new int[n][n];
            int[][] matrix270 = new int[n][n];

            //input
            for (int i = 0; i < n; i++) {
                for(int j=0;j<n;j++){
                    matrix[i][j] = sc.nextInt();
                }
            }

            //get 90 degree rotate
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix90[i][j] = matrix[n-j-1][i];
                }
            }
            //get 180 degree rotate
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix180[i][j] = matrix[n - i - 1][n - j - 1];
                }
            }
            //get 270 degree rotate
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix270[i][j] = matrix[j][n-i-1];
                }
            }
            //print
            System.out.println("#"+test_case);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix270[i][j]);
                }
                System.out.print("\n");
            }

        }
    }
}
