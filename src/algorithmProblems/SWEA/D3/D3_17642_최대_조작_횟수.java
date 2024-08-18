package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_17642_최대_조작_횟수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            sb.append("#").append(test_case).append(" ").append(getMaxCount(input[0], input[1])).append("\n");
        }
        System.out.print(sb);
    }

    public static long getMaxCount(long a, long b) {
        if (a == b) return 0;
        if (b - a == 1 || a > b) return -1;
        return (b - a) / 2;
    }
}
