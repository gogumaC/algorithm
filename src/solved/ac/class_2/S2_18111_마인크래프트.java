package solved.ac.class_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_18111_마인크래프트 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = input[0];
        int M = input[1];
        int B = input[2];

        int[][] field = new int[N][M];

        int sum = 0;
        int min = Integer.MAX_VALUE;


        for (int i = 0; i < N; i++) {
            field[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                sum += field[i][j];
                if (min > field[i][j]) {
                    min = field[i][j];
                }
            }
        }
        int max = (sum + B) / (N * M);

        int maxHeight = 0;
        int minTime = Integer.MAX_VALUE;
        for (int h = max; h >= min; h--) {
            int time = 0;
            int remove = 0;
            int add = 0;
            int b = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int current = field[i][j];
                    if (current > h) {
                        remove += current - h;
                        b += current - h;
                    } else if (current < h) {
                        add += h - current;
                    }
                }
            }
            if (add > b) continue;

            time += add + remove * 2;
            //System.out.println(add + " " + remove + "| time: " + time + " h: " + h);
            if (time < minTime) {
                minTime = time;
                maxHeight = h;
            }
        }
        System.out.print(minTime + " " + maxHeight);
    }

}
