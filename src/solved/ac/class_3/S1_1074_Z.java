package solved.ac.class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_1074_Z {
    static int N=0;
    static int R=0;
    static int C=0;
//dfs로 풀때 선언해둔 배열때문에 자꾸 메모리 초과가 났다. 필요없어진 변수는 바로바로 삭제하자..!
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder=new StringBuilder();

        int[] input= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N=(int)Math.pow(2.0,input[0]);
        R=input[1];
        C=input[2];
        builder.append(getIndex2(R,C,N/2));
        System.out.print(builder);
    }


    static int getIndex2(int r, int c, int n){

        int sum=0;
        while(true){
            if(n==1)return sum+2*r+c;
            int blockR=r/n;
            int blockC=c/n;
            int blockNum=0;
            if(blockR==0&&blockC==1)blockNum=1;
            else if(blockR==1&&blockC==0)blockNum=2;
            else if(blockR==1&&blockC==1)blockNum=3;
            sum+=blockNum*n*n;
            r%=n;
            c%=n;
            n/=2;
        }
    }
    /*static int getIndex(int r, int c, int n){
        if(n==1)return 2*r+c;
        int blockR=r/n;
        int blockC=c/n;
        int blockNum=0;
        if(blockR==0&&blockC==1)blockNum=1;
        else if(blockR==1&&blockC==0)blockNum=2;
        else if(blockR==1&&blockC==1)blockNum=3;

        return blockNum*n*n+getIndex(r%n,c%n,n/2);

    }
    static int limitDfs(){
        int r=0;
        int c=0;
        int n=N/2;
        int index=0;
        while(true){
            if(n==1){
                if(r==R&&c==C) return index;
                index++;c++;
                if(r==R&&c==C) return index;
                index++;r++;
                if(r==R&&c==C) return index;
                index++;r++;c++;
                if(r==R&&c==C) return index;
                index++;

            }else{
                r+=n;
                c+=n;
                n/=2;
            }
        }
    }
    static void dfs(int r, int c,int n){

        if (n == 1) {
            setIndex(r,c);
            setIndex(r,c+1);
            setIndex(r+1,c);
            setIndex(r+1,c+1);
            return;
        }
        else{
            dfs(r, c, n / 2);
            dfs(r,c+n,n/2);
            dfs(r+n,c,n/2);
            dfs(r+n,c+n,n/2);
        }

    }

    static void setIndex(int r, int c){
        arr[r][c]=index;
        index++;
    }*/
}


