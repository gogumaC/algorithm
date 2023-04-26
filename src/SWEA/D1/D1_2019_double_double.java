package SWEA.D1;

import java.util.Scanner;

import static java.lang.StrictMath.pow;

public class D1_2019_double_double {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=0;i<=n;i++){
            System.out.print((int)pow(2,i)+" ");
        }
    }
}
