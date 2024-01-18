package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1027_고층_건물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] height = new int[n];
        boolean[][] isVisible = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(isVisible[i], true);
            isVisible[i][i] = false;
        }

        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            double maxSlope = Integer.MIN_VALUE;
            int leftCount = 0;
            for (int j = 0; j < i; j++) {
                if (isVisible[i][j]) leftCount++;
            }
            for (int j = i + 1; j < n; j++) {
                if (i == j || !isVisible[i][j]) continue;
                double slope = (double) (height[j] - height[i]) / (j - i);
                if (slope > maxSlope) {
                    count++;
                    maxSlope = slope;
                } else {
                    isVisible[i][j] = false;
                    isVisible[j][i] = false;
                }
            }
            max = Math.max(max, count + leftCount);
        }

        System.out.println(max);


    }
}
