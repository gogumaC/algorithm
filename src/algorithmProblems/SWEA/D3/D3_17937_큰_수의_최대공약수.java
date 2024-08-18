package SWEA.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_17937_큰_수의_최대공약수 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            String[] input = br.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            sb.append("#").append(test_case).append(" ").append(findGCD(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    public static String findGCD(String a, String b) {
        if (a.equals(b)) return a;
        else return "1";
    }
}
