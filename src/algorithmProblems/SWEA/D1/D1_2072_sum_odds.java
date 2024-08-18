package SWEA.D1;

import java.util.Scanner;

public class D1_2072_sum_odds {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int oddSum=0;
            String[] arr=sc.nextLine().split(" ");
            for(int i=0;i<10;i++){
                int num=Integer.parseInt(arr[i]);
                if(num%2!=0)oddSum+=num;
            }
            System.out.println("#"+test_case+" "+oddSum);

        }
    }
}
