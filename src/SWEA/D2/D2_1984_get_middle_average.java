package SWEA.D2;
import java.util.Scanner;

public class D2_1984_get_middle_average {

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int max=0;
            int min=10000;
            int sum=0;
            int count=10;
            int mCount=0;
            String[] input=sc.nextLine().split(" ");
            int[] arr=new int[count];

            for(int i=0;i<count;i++){
                int n=Integer.parseInt(input[i]);
                arr[i]=n;
                if(n>max)max=n;
                if(n<min)min=n;
            }

            for(int i=0;i<count;i++){
                 if(arr[i]!=max && arr[i]!=min){
                 sum+=arr[i];
                 mCount++;
                 }
            }

            if(mCount!=0) System.out.println("#"+test_case+" "+Math.round((double)sum/mCount));
            else System.out.println("#"+test_case+" "+0);
        }
    }

}
