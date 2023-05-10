package SWEA.D2;

import java.util.Scanner;

public class D2_1970_easy_change {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n=sc.nextInt();
            int[] unitCount=new int[8];
            int[] unit=new int[]{50000,10000,5000,1000,500,100,50,10};
            for(int i=0;i<8;i++){
                unitCount[i]=n/unit[i];
                n%=unit[i];
            }

            System.out.println("#"+test_case);
            for(int i=0;i<8;i++){
                System.out.print(unitCount[i]+" ");
            }
            System.out.print("\n");

        }
    }
}
