package SWEA.D2;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class D2_2005_pascals_triangle {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(System.out);
        BufferedWriter bw=new BufferedWriter(outputStreamWriter);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        int[][] pascal=new int[30][30];

        for(int i=0;i<30;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i)pascal[i][j]=1;
                if(i<29&&j<29) pascal[i+1][j+1]=pascal[i][j]+pascal[i][j+1];
            }
        }

        for(int test_case = 1; test_case <= T; test_case++)
        {
            bw.write("#"+test_case+"\n");
            int n=sc.nextInt();

            for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    bw.write(pascal[i][j]+" ");
                }
                bw.write("\n");
            }

        }
        bw.flush();
    }
}
