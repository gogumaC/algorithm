package SWEA.D1;

import java.util.Scanner;

public class D1_2068_get_max {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int max=0;
            for(int i=0;i<10;i++){
                int num=sc.nextInt();
                max=num>max?num:max;
            }

            System.out.println("#"+test_case+" "+max);

        }
    }
}
