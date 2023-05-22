package solved.ac.class_2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Deque_10866 {

    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
        Deque<Integer> dq=new ArrayDeque<Integer>();
        int n=Integer.parseInt(sc.nextLine().trim());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<n;i++){
            String[] input=sc.nextLine().trim().split(" ");
            switch(input[0]){
                case "push_front": dq.addFirst(Integer.parseInt(input[1]));
                    break;
                case "push_back": dq.addLast(Integer.parseInt(input[1]));
                    break;
                case "pop_front": {
                    bw.write((dq.isEmpty())?"-1":Integer.toString(dq.removeFirst()));
                    bw.write("\n");
                    break;
                }
                case "pop_back":{
                    bw.write((dq.isEmpty())?"-1":Integer.toString(dq.removeLast()));
                    bw.write("\n");
                    break;
                }
                case "size": bw.write(Integer.toString(dq.size()));//System.out.println(dq.size());
                    bw.write("\n");
                    break;
                case "empty":{
                    bw.write((dq.isEmpty())?"1":"0");
                    bw.write("\n");
                    break;
                }
                case "front":{
                    bw.write((dq.isEmpty())?"-1":Integer.toString(dq.getFirst()));
                    bw.write("\n");
                    break;
                }
                case "back":{
                    bw.write((dq.isEmpty())?"-1":Integer.toString(dq.getLast()));
                    bw.write("\n");
                    break;
                }
            }

        }
        bw.flush();

    }
}
