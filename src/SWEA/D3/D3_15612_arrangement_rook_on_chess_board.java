package SWEA.D3;

import java.util.Scanner;
import java.util.stream.IntStream;

public class D3_15612_arrangement_rook_on_chess_board {

    static final int CHESS_N=8;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[][] isRook=new int[CHESS_N][CHESS_N];
            for(int i=0;i<CHESS_N;i++){
                IntStream input=sc.nextLine().chars();
                isRook[i]=input.map( c-> (char)c=='O'?1:0).toArray();
            }
            String ans=checkRookPosition(isRook)?"yes":"no";
            System.out.println("#"+test_case+" "+ans);
        }
    }

    static boolean checkRookPosition(int[][] isRook){
        boolean[] rowMark=new boolean[CHESS_N];
        boolean[] columnMark=new boolean[CHESS_N];
        int rookCount=0;

        for(int r=0;r<CHESS_N;r++){
            for(int c=0;c<CHESS_N;c++){
                if(isRook[r][c]==1){
                    rookCount++;
                    if(rowMark[r]||columnMark[c]||rookCount>8) return false;
                    rowMark[r]=true;
                    columnMark[c]=true;
                }
            }
        }
        return rookCount==8;
    }

}
