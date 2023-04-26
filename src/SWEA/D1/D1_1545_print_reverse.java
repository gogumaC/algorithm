package SWEA.D1;

import java.util.Scanner;

public class D1_1545_print_reverse {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=n;i>=0;i--){
            System.out.print(i+" ");
        }
    }
}
