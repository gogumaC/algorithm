package SWEA.D2;

import java.util.Scanner;

public class D2_1976_time_addition {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int h1=sc.nextInt();
            int m1=sc.nextInt();
            int h2=sc.nextInt();
            int m2=sc.nextInt();

            int m=(m1+m2)%60;
            int h=(h1+h2+(m1+m2)/60)%12;
            if(h==0)h=12;
            System.out.println("#"+test_case+" "+h+" "+m);

        }
    }

}
