package solved.ac.class_2;

import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;


public class Sort_Coordinate_11650 {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();

        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            int[] input=Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i][0]=input[0];
            arr[i][1]=input[1];
        }
        Comparator<int[]> c=new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            }
        };

        Arrays.stream(arr)
                .sorted(c)
                .forEach(it->System.out.println(it[0]+" "+it[1]));

    }


}
