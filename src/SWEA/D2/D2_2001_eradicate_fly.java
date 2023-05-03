package SWEA.D2;

import java.util.Scanner;

public class D2_2001_eradicate_fly {
    public static void main(String args[]) throws Exception
    {


        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int n=sc.nextInt();
            int m=sc.nextInt();

            int[][] arr=new int[n][n];
            for(int i=0;i<n*n;i++){
                arr[i/n][i%n]=sc.nextInt();
            }


            int max=0;
            for(int startRow=0;startRow<=n-m;startRow++){
                for(int startColumn=0;startColumn<=n-m;startColumn++){
                    max=Math.max(max,sumArea(arr,startRow,startColumn,m));
                }
            }
            System.out.println("#"+test_case+" "+max);
        }

    }

    static int sumArea(int[][] arr,int startRow,int startColumn,int m){
        int sum=0;
        for(int i=startRow;i<startRow+m;i++){
            for(int j=startColumn;j<startColumn+m;j++){
                sum+=arr[i][j];
            }
        }
        return sum;
    }
}
