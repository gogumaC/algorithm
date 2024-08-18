package SWEA.D1;

import java.util.Scanner;

public class D1_2025_n_line_addition {
    public static void main(String args[]) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=n*(n+1)/2;

        System.out.println(sum);
    }
}
