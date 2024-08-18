package SWEA.D1;

import java.util.Scanner;

public class D1_1933_simple_n_divisors {
    public static void main(String args[]) throws Exception
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print("1 ");
        for(int i=2;i<=n;i++){
            if(n%i==0){
                System.out.print(i);
                if(i!=n)System.out.print(" ");
            }
        }
    }
}
