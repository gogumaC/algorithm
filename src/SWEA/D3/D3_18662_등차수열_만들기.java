package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_18662_등차수열_만들기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        int T;
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int a = input[0];
            int b = input[1];
            int c = input[2];

            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            sb.append(findMin(a, b, c));
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static double findMin(int a, int b, int c) {
        if (c - b == b - a) return 0;
        return Math.abs((a + c) / 2.0 - b);
    }
}
