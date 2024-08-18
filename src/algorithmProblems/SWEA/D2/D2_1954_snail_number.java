package SWEA.D2;

import java.util.Scanner;

public class D2_1954_snail_number {
/*
* 풀이 개요
* 1. 상하좌우일때 케이스 구분해서 방향 전환해줌
* */
    public static final int RIGHT=0;
    public static final int BOTTOM=1;
    public static final int LEFT=2;
    public static final int TOP=3;


    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();



        for(int test_case = 1; test_case <= T; test_case++)
        {

            int n=sc.nextInt();
            int[][] arr=new int[n][n];

            drawSnail(arr,n);

            System.out.println("#"+test_case);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.print("\n");
            }
        }
    }

    static void drawSnail(int[][] arr, int n){
        int direction=RIGHT;
        int index=1;
        int x=0;
        int y=0;
        while(index<=n*n){
            arr[y][x]=index;
            index++;

            switch(direction){
                case RIGHT : {
                    if(x==n-1||arr[y][x+1]!=0){
                        direction=BOTTOM;
                        y++;
                    }
                    else x++;
                    break;
                }
                case BOTTOM:{
                    if(y==n-1||arr[y+1][x]!=0){
                        direction=LEFT;
                        x--;
                    }
                    else y++;
                    break;
                }
                case LEFT:{
                    if(x==0||arr[y][x-1]!=0){
                        direction=TOP;
                        y--;
                    }
                    else x--;
                    break;
                }
                default:{
                    if(y==0||arr[y-1][x]!=0){
                        direction=RIGHT;
                        x++;
                    }
                    else y--;
                }
            }
        }

    }
}
