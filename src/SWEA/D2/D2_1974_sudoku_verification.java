package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1974_sudoku_verification {

    /*
    * 풀이 개요
    * 1. 모든 가로줄을 확인해서 겹치는 수가 있는 가로줄이 있는지 확인
    * 2. 모든 세로줄을 확인해서 겹치는 수가 있는 세로줄이 있는지 확인
    * 3. 모든 블록을 확인해서 겹치는 수가 있는 블록이 있는지 확인
    *
    * 다른 풀이법 : 각 구역별로 1~9까지의 합이 45인지 확인하여 검증 -> 케이스에 따라 안될 가능성 있음
    * */
    public static final int N=9;
    public static final int BLOCK_N=N/3;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[][] sudoku=new int[N][N];
            int[][] reversedSudoku=new int[N][N];
            for(int i=0;i<N;i++){
                sudoku[i]= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    reversedSudoku[j][i]=sudoku[i][j];
                }
            }
            int ans=(checkLines(sudoku)&&checkLines(reversedSudoku)&&checkBlock(sudoku))?1:0;

            System.out.println("#"+test_case+" "+ans);
        }
    }

    //가로,세로줄에 겹치는 수가 있는지 확인
    static boolean checkLines(int[][] sudoku){

        for(int i=0;i<N;i++){
            boolean[] markNums=new boolean[N+1]; // 있는 수를 기록
            for(int j=0;j<N;j++){
                if(!markNums[sudoku[i][j]]) markNums[sudoku[i][j]]=true; //이전에 없던 수면 markNums에 해당인덱스를 true로 변경
                else return false;//이미 체크한 수이므로 false반환 -> 해당 줄에 겹치는 수가 있으므로 스도쿠 규칙에 어긋나는 스도쿠임
            }
        }
        return true;
    }

    //블록에 겹치는 수가 있는지 확인
    static boolean checkBlock(int[][] sudoku){

        for(int i=0;i<9;i++){//블록 순회
            boolean[] markNums=new boolean[N+1];

            for(int j=0;j<BLOCK_N;j++){ //블록 세로 순회
                for(int k=0;k<BLOCK_N;k++){ //블록 가로 순회
                    if(!markNums[sudoku[j+i/BLOCK_N*BLOCK_N][k+i%BLOCK_N*BLOCK_N]]) markNums[sudoku[j+i/BLOCK_N*BLOCK_N][k+i%BLOCK_N*BLOCK_N]]=true;
                    else return false;
                }
            }
        }
        return true;
    }
}
