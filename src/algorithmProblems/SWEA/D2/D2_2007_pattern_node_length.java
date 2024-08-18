package SWEA.D2;

import java.util.Scanner;

public class D2_2007_pattern_node_length {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        int res;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            res=0;
            String input=sc.nextLine();
            System.out.println(input);
            int inputLength=30;
            for(int node=1;node<=inputLength;node++){
                String pattern=input.substring(0,node);

                int startIndex=0;
                int finishIndex=startIndex+node;
                boolean escapeFlag=false;
                while(startIndex<inputLength){
                    String split=input.substring(startIndex, Math.min(finishIndex, inputLength));
                    if(split.length()==node&&!split.equals(pattern)) {
                        escapeFlag=true;
                        break;
                    }
                    if(split.length()<node&&!pattern.substring(0,split.length()).equals(split)) {
                        escapeFlag=true;
                        break;
                    }
                    startIndex=finishIndex;
                    finishIndex=startIndex+node;
                }
                if(escapeFlag)continue;
                res=node;
                break;
            }
            System.out.println("#"+test_case+" "+res);

        }
    }
}
