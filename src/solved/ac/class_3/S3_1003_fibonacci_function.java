package solved.ac.class_3;

import java.io.*;

public class S3_1003_fibonacci_function {

    static int[] fiboZero=new int[41];
    static int[] fiboOne=new int[41];
    static boolean[] fiboMark=new boolean[41];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(br.readLine());

        fiboZero[0]=1;
        fiboZero[1]=0;
        fiboOne[0]=0;
        fiboOne[1]=1;
        fiboMark[0]=true;
        fiboMark[1]=true;

        for(int i=0;i<n;i++){
            int input=Integer.parseInt(br.readLine());
            fibonacci(input);
            bw.write(fiboZero[input]+" "+fiboOne[input]+"\n");
        }

        bw.flush();
    }

    static void fibonacci(int n){

        if(!fiboMark[n]) {
            fiboMark[n]=true;
            fibonacci(n-2);
            fibonacci(n-1);
            fiboOne[n]=fiboOne[n-1]+fiboOne[n-2];
            fiboZero[n]=fiboZero[n-1]+fiboZero[n-2];

        }

    }

}
