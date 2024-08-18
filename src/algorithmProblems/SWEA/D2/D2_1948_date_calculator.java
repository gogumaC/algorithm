package SWEA.D2;

import java.util.Scanner;

public class D2_1948_date_calculator {

    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[] monthDays=new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int m1=sc.nextInt();
            int d1=sc.nextInt();
            int m2=sc.nextInt();
            int d2=sc.nextInt();

            int ans=0;
            if(m1==m2) ans=d2-d1+1;
            else{
                ans=monthDays[m1]-d1+d2+1;
                for(int i=1;i<m2-m1;i++){
                    ans+=monthDays[m1+i];
                }
            }
            System.out.println("#"+test_case+" "+ans);

        }
    }

}
