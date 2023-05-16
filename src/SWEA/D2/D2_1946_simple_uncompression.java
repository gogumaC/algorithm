package SWEA.D2;

import java.util.Scanner;

public class D2_1946_simple_uncompression {

    /*
    * 풀이 개요
    * 1.입력에서 알파벳과 숫자 분리
    * 2.해당 숫자로 알파벳을 문자열에 하나씩 추가하며 10 단위 마다 줄바꿈 추가
    * 3. 문자열 출력
    * */
    
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int count=0;
            String file="";
            int n=sc.nextInt();
            sc.nextLine();
            System.out.println("#"+test_case);
            for(int i=0;i<n;i++){
                String[] input=sc.nextLine().split(" ");
                String st=input[0];
                int cCount=Integer.parseInt(input[1]);
                for(int j=0;j<cCount;j++){
                    file+=st;
                    count++;
                    if(count%10==0) file+="\n";
                }
            }

            System.out.println(file);

        }
    }

}
