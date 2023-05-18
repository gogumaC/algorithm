package SWEA.D3;

import java.util.Scanner;

public class D3_14555_ball_and_weed {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int count=0;
            String input=sc.nextLine().replaceAll("\\(\\)","0");
//            System.out.println(input);
            for(char c : input.toCharArray()){
                if(c!='|'&&c!='.')count++;
            }
            System.out.println("#"+test_case+" "+count);


        }
    }

}
