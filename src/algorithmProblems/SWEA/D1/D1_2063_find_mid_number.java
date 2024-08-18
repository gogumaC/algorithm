package SWEA.D1;

import java.util.Arrays;
import java.util.Scanner;

public class D1_2063_find_mid_number {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        //sorting
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        //find mid num
        System.out.println(arr[n/2]);
    }
}
