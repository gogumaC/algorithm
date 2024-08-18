package SWEA.D1;

import java.util.Scanner;

public class D1_2070_big_small_same_things {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n1=sc.nextInt();
            int n2=sc.nextInt();
            char ans='=';
            if(n1>n2)ans='>';
            else if(n1<n2)ans='<';

            System.out.println("#"+test_case+" "+ans);

        }
    }
}
