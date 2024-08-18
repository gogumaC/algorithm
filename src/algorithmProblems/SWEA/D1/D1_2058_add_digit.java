package SWEA.D1;

import java.util.Scanner;

public class D1_2058_add_digit {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        String n=sc.nextLine();

        int sum=0;
        for(int i=0;i<n.length();i++){
            sum+=Integer.parseInt(n.substring(i,i+1));
        }
        System.out.println(sum);

    }
}
