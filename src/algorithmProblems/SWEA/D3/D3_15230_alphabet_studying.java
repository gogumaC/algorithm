package SWEA.D3;

import java.util.Scanner;

public class D3_15230_alphabet_studying {

    public static void main(String args[]) throws Exception
    {
        char[] alphabet="abcdefghijklmnopqrstuvwxyz".toCharArray();
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            char[] input=sc.nextLine().toCharArray();
            int count=0;
            for(int i=0;i<input.length;i++){
                if(input[i]==alphabet[i])count++;
                else break;
            }
            System.out.println("#"+test_case+" "+count);



        }
    }
}
