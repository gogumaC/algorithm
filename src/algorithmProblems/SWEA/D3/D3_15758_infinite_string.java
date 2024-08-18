package SWEA.D3;

import java.util.Scanner;

public class D3_15758_infinite_string {

    /*
    * 풀이개요
    * 1. 처음에는 긴 문자열을 기준으로 짧은 문자열을 반복시켜 같은 길이의 문자열로 만들어서 같은지 비교
    * -> ab, aba처럼 패턴이 반복되지 않는 문자열을 처리하지 못함 (ababab... , abaabaaba...)
    *
    * 2. 최소공배수를 기준으로 두 문자열을 맞춰서 같은지 비교
    * ->최소공배수를 구하기 위해 최대 공약수를 유클리드 호제법을 사용해 구함
    * */
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] s=sc.nextLine().split(" ");

            boolean isEqual= checkEqual(s[0],s[1]);
            String ans=isEqual?"yes":"no";
            System.out.println("#"+test_case+" "+ans);

        }
    }

    static boolean checkEqual(String s1,String s2){

        int gcd=getGCD(s1.length(),s2.length());
        int lcm=s1.length()*s2.length()/gcd;
        StringBuilder ns1= new StringBuilder();
        StringBuilder ns2= new StringBuilder();
        for(int i=0;i<lcm/s1.length();i++){
            ns1.append(s1);
        }
        for(int i=0;i<lcm/s2.length();i++){
            ns2.append(s2);
        }
        return ns1.toString().contentEquals(ns2);
    }

    static int getGCD(int n1,int n2){

        int big=Math.max(n1,n2);
        int small=Math.min(n1,n2);
        int r=big%small;;
        while(r!=0){
            big=small;
            small=r;
            r=big%small;
        }
        return small;

    }
}
