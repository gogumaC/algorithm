package SWEA.D2;



import java.util.*;

public class D2_1859_millionaire_project {


    static long money=0;
    static int count=0;

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            money=0;
            count=0;
            int n= Integer.parseInt(sc.nextLine());


            String[] arr=sc.nextLine().split(" ");

            int max=0;//Integer.parseInt(arr[n-1]);

            for(int i=n-1;i>=0;i--){
                if(Integer.parseInt(arr[i])>max){
                    sellAll(max);
                    max=Integer.parseInt(arr[i]);
                }else{
                    buy(Integer.parseInt(arr[i]));
                    if(i==0)sellAll(max);
                }
            }



            System.out.println("#"+test_case+" "+money);

        }
        sc.close();
    }

    static void sellAll(int price){
        money+=(long)count*(long)price;
        count=0;
    }
    static void buy(int price){
        count++;
        money-=price;
    }
}
