package SWEA.D1;

import java.util.Scanner;

public class D1_2050_alphbet_to_number {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        char[] input=sc.nextLine().toCharArray();

        for(int i=0;i<input.length;i++){
            System.out.print(input[i]-'A'+1+" ");
        }
    }

}
