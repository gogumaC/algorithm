package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D3_16002_composite_number_equation {
    /*
    * 풀이개요
    * 빼서 n이 나오는 수는 x=n*k, y=n*(k-1) ->x-y=n
    * n*k, n*(k-1)은 합성수이어야하므로 k,k-1이 합성수여야 n에 관계없이 x,y가 언제나 합성수가 나오게됨
    * 예를 들어 k=3(합성수 아님)일경우 n=1이라면 x-y=n이지만 x=3,y=2가 되고 3,2는 합성수가 아니므로 부적절함
    * k=9(합성수) 인 경우 n이 무엇이든 곱한값은 언제나 합성수가 나옴!
    * */
    public static void main(String args[]) throws Exception
    {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String input=br.readLine().replaceAll("\\D","");
            if(!input.isEmpty()){
                int n=Integer.parseInt(input);
                int x=n*9;
                int y=n*8;
                System.out.print("#"+test_case+" "+x+" "+y+ "\n");
            }
        }
    }
}
