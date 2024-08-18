package solved.ac.class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class S1_1389_케빈_베이컨의_6단계_법칙 {

    static int N = 0;
    static int M = 0;

    static boolean[][] relation;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        relation = new boolean[N + 1][N + 1];
        result = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int[] rel = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int p1 = rel[0];
            int p2 = rel[1];

            relation[p1][p2] = true;
            relation[p2][p1] = true;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 1; i <= N; i++) {
            int kevin = bfs(i);
            if (kevin < min) {
                min = kevin;
                minIndex = i;
            }

        }

        System.out.println(minIndex);
    }

    public static int bfs(int start) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(start);
        boolean[] mark = new boolean[N + 1];
        mark[start] = true;
        while (!q.isEmpty()) {
            int current = q.pop();
            for (int i = 1; i <= N; i++) {
                if (relation[current][i] && !mark[i]) {
                    q.add(i);
                    mark[i] = true;
                    result[start][i] = result[start][current] + 1;
                }
            }
        }
        int sum = Arrays.stream(result[start]).sum();
        return sum;
    }

}
