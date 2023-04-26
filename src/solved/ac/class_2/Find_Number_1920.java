package solved.ac.class_2;

import java.util.HashSet;
import java.util.Scanner;

public class Find_Number_1920 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        HashSet<Integer> set= new HashSet<Integer>();
        String[] nums=sc.nextLine().split(" ");

        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(nums[i]));
        }

        int m=sc.nextInt();
        sc.nextLine();

        String[] checkNums=sc.nextLine().split(" ");


        for(int i=0;i<m;i++){
            int num=Integer.parseInt(checkNums[i]);
            System.out.println(set.contains(num)?1:0);
        }
    }
}
