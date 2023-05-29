package solved.ac.class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S2_1012_organic_cabbage {

    static int[][] field;
    static int count=0;
    static int m=0;
    static int n=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int test_case=Integer.parseInt(br.readLine());
        StringBuilder builder=new StringBuilder();
        for(int T=0;T<test_case;T++){
            count=0;
            String[] input= br.readLine().split(" ");
            m=Integer.parseInt(input[0]);
            n=Integer.parseInt(input[1]);
            int cabbageCount=Integer.parseInt(input[2]);

            field=new int[m][n];

            for(int i=0;i<cabbageCount;i++){
                String[] pos=br.readLine().split(" ");
                int x=Integer.parseInt(pos[0]);
                int y=Integer.parseInt(pos[1]);
                field[x][y]=1;

            }

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(field[i][j]==1) {
                        count++;
                        //dfs(i,j);
                        bfs(i,j);
                    }
                }
            }

            builder.append(count+"\n");

        }
        System.out.print(builder);
    }

    static void bfs(int startX, int startY){
        //인접레벨 검사
        Stack<int[]> stack= new Stack<>();
        field[startX][startY]=2;
        stack.push(new int[]{startX,startY});
        int x=startX;
        int y=startY;
        while(!stack.empty()){

            if(x>0&&field[x-1][y]==1){
                stack.push(new int[]{x-1,y});
                field[x-1][y]=2;
            }
            if(x<m-1&&field[x+1][y]==1){
                stack.push(new int[]{x+1,y});
                field[x+1][y]=2;
            }
            if(y>0&&field[x][y-1]==1){
                stack.push(new int[]{x,y-1});
                field[x][y-1]=2;
            }
            if(y<n-1&&field[x][y+1]==1){
                stack.push(new int[]{x,y+1});
                field[x][y+1]=2;
            }


            int[] next=stack.pop();
            x=next[0];
            y=next[1];
        }
    }

    static void dfs(int x, int y){
        field[x][y]=2;
        if(x>0&&field[x-1][y]==1){
            dfs(x-1,y);
        }
        if(y>0&&field[x][y-1]==1){
            dfs(x,y-1);
        }
        if(x<m-1&&field[x+1][y]==1){
            dfs(x+1,y);
        }
        if(y<n-1&&field[x][y+1]==1){
            dfs(x,y+1);
        }
    }


}
