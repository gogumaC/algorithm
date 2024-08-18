package SWEA.D2;

import java.util.Scanner;

public class D2_1979_where_can_the_word_fit {

    //풀이 개요 
    /*
    * 1. 가로 방향에서 조건에 맞는거 다셈
    * 2. 세로 방향에서 조건에 맞는거 다셈
    * 3. 둘이 더함
    * */
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();


            boolean[][] arr=new boolean[n][n]; // 원래 배열
            boolean[][] reversedArr=new boolean[n][n]; // 가로, 세로가 바뀐 (전치된) 배열

            //이중 for 문을 통해 arr, reversedArr을 한번에 채움
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=(sc.nextInt()==1);
                    reversedArr[j][i]=arr[i][j];
                }
            }

            //checkArr에서 각 배열에서의 가로 방향 배열을 세고 둘이 더함
            int ans=checkArr(arr,n,k)+checkArr(reversedArr,n,k);
            System.out.println("#"+test_case+" "+ans);

        }
    }

    static int checkArr(boolean[][] arr, int n, int k){
        int count=0;


        for(int i=0;i<n;i++){
            int wCount=0;
            for(int j=0;j<n;j++){
                if(arr[i][j]) wCount++; // 처음하얀 공간을 만나면 하얀공간 카운트 시작
                else if(wCount==k){ // 만약 검은 공간이 나왔는데 하얀공간 카운트가 k면 하나 올리고 wCount초기화 해서 다시 셈
                    count++;
                    wCount=0;
                }
                else wCount=0;//만약 검은 공간이 나왔는데 하얀공간 카운트가 k가 아니면 wCount초기화 해서 다시 셈
            }
            if (wCount==k) count++;//한줄을 다 센 시점에서 wCount가 k면 하나 올림
        }
        return count   ;
    }
}
