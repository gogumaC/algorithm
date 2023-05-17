package SWEA.D3;

import java.util.Scanner;

public class D3_15941_parallelogram {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int n=sc.nextInt();
            n=n*n;
            System.out.println("#"+test_case+" "+n);

        }
    }
}
