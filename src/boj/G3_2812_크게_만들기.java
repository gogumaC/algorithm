package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class G3_2812_크게_만들기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int limit = input[1];
        char[] num = br.readLine().toCharArray();
        int count = 0;
        ArrayDeque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < num.length; i++) {
            if (st.isEmpty()) {
                st.push(num[i]);
                continue;
            }

            char compare = num[i];

            while (!st.isEmpty() && st.getFirst() < compare && count < limit) {
                st.pop();
                count++;
            }
            st.push(compare);

        }

        if (count != limit) {
            for (int i = 0; i < limit - count; i++) {
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.removeLast());
        }

        System.out.print(sb);
    }
}
