package solved.ac.class_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S1_1697_catch_that_cow {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder=new StringBuilder();

        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int k=Integer.parseInt(input[1]);

        builder.append(bfs(n,k));
        System.out.println(builder);

    }

    static int bfs(int n,int k){
        if(n<k){
            Queue<Integer> queue=new LinkedList<>();
            int[] dist=new int[k*2+1];
            boolean[] mark=new boolean[k*2+1];

            dist[n]=0;
            mark[n]=true;
            queue.add(n);

            while(!queue.isEmpty()){

                int current=queue.peek();
                queue.remove();

                if(current==k)break;
                if(current*2<dist.length&&!mark[current*2]){
                    queue.add(current*2);
                    mark[current*2]=true;
                    dist[current*2]=dist[current]+1;
                }
                if(current+1<dist.length&&!mark[current+1]){
                    queue.add(current+1);
                    mark[current+1]=true;
                    dist[current+1]=dist[current]+1;
                }
                if(current>0&&!mark[current-1]){
                    queue.add(current-1);
                    mark[current-1]=true;
                    dist[current-1]=dist[current]+1;
                }

            }
            return dist[k];
        }else return n-k;

    }

}
