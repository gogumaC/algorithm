package SWEA.D2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class D2_1926_simple_369_game {

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(System.out);
        BufferedWriter bw=new BufferedWriter(outputStreamWriter);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            String num=Integer.toString(i);
            int index=0;
            String res="";
            while(index<num.length()){
                String digit=num.substring(index,index+1);
                if(digit.equals("3")||digit.equals("6")||digit.equals("9")) {
                    res += "-";
                }
                if(index==num.length()-1){
                    if(res.isEmpty())bw.write(num);
                    else bw.write(res);
                }
                index++;

            }
            bw.write(" ");

        }
        bw.flush();
    }
}
