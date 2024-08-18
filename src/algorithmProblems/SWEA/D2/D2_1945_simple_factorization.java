package SWEA.D2;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
* 풀이 개요
* 1. 소수를 배열에 넣음
* 2. 소수를 한번씩 순환하면서 수를 해당 소수로 나눠서 나머지가  0이 나오지 않을때까지 나눔
* 3. 이때 나눠지는 수만큼 해당 소수 인덱스와 같은 인덱스의 다른 배열에 저장함
* * */
public class D2_1945_simple_factorization {

    public static void main(String args[]) throws Exception
    {

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();



        for(int test_case = 1; test_case <= T; test_case++)
        {
            bw.write("#"+test_case+" ");
            int n=sc.nextInt();
            int[] primes=new int[]{2,3,5,7,11};
            int[] exp=new int[primes.length];
            for(int i=0;i<primes.length;i++){

                while(n%primes[i]==0){
                    exp[i]++;
                    n/=primes[i];
                }
                bw.write(exp[i]+" ");
            }
            bw.write("\n");
            bw.flush();

        }
    }

}

