package SWEA.D1;

import java.util.Scanner;

public class D1_2071_get_average {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] arr=sc.nextLine().split(" ");

            int sum=0;
            for(int i=0;i<10;i++){
                sum+=Integer.parseInt(arr[i]);
            }

            int avg=(int)(sum/10f+0.5);

            System.out.println("#"+test_case+" "+avg);
        }
    }
}
