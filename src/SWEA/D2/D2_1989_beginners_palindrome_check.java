package SWEA.D2;

import java.util.Scanner;

public class D2_1989_beginners_palindrome_check {


    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String input=sc.nextLine();
            int isPalindrome=1;
            for(int i=0;i<input.length()/2;i++){
                String front=input.substring(i,i+1);
                String back=input.substring(input.length()-i-1,input.length()-i);
                if(!front.equals(back)){
                    isPalindrome=0;
                    break;
                }
            }
            System.out.println("#"+test_case+" "+isPalindrome);

        }
    }

}
