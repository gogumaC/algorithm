package solved.ac.class_3;

import java.io.*;

public class S3_1463_make_one {

    private static int[] res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        res = new int[n + 1];
        int count = dp(n);//dfs(n);

        builder.append(dfs(n));
        builder.append(" ");
        builder.append(count);
        System.out.println(builder);
    }

    static int dfs(int n) {

        if (res[n] != 0) return res[n];

        int[] counts = new int[4];
        if (n == 3 || n == 2) return 1;
        if (n % 3 == 0) {
            counts[3] += dfs(n / 3) + 1;
        }
        if (n % 2 == 0) {
            counts[2] += dfs(n / 2) + 1;
        }
        counts[1] += dfs(n - 1) + 1;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0 && counts[i] < min) min = counts[i];
        }

        res[n] = min;
        return min;
    }


    static int dp(int n){


        int[] res=new int[n+1];
        if(n>2) res[3]=1;
        if(n>1)res[2]=1;

        for(int i=4;i<=n;i++){
            int min=Integer.MAX_VALUE;
            if(i%2==0) min=Math.min(res[i/2],min);
            if(i%3==0) min=Math.min(res[i/3],min);
            min=Math.min(res[i-1],min);

            res[i]=min+1;
        }

        return res[n];
    }
}

