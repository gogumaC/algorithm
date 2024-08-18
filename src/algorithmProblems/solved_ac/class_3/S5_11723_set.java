package solved.ac.class_3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class S5_11723_set {

    static private Set<Integer> set= new HashSet <Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int m=Integer.parseInt(br.readLine().trim());
        for(int i=0;i<m;i++){
            String[] input=br.readLine().trim().split(" ");
            switch(input[0]){
                case "add" : add(Integer.parseInt(input[1]));
                    break;
                case "remove" : remove(Integer.parseInt(input[1]));
                    break;
                case "check" : bw.write(check(Integer.parseInt(input[1]))+"\n");
                    break;
                case "toggle" : toggle(Integer.parseInt(input[1]));
                    break;
                case "all" : all();
                    break;
                case "empty" : empty();
            }

        }
        bw.flush();
    }

    static void add(int x){ set.add(x); }
    static void remove(int x){ set.remove(x); }
    static int check(int x){ return (set.contains(x))?1:0; }
    static void toggle(int x){
        if(!set.contains(x))set.add(x);
        else set.remove(x);
    }
    static void all(){
        IntStream st=IntStream.rangeClosed(1,20);
        set=new HashSet<Integer>();
        set.addAll(st.boxed().collect(Collectors.toList()));

    }
    static void empty(){
        set=new HashSet<Integer>();
    }
}
