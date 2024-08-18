package SWEA.D2;

import java.util.Scanner;
/*
* 풀이 개요
* !주의 : 가속이 1초에 걸쳐 일어나는게 아니라고 가정해야함..
*  가속, 감속시 바로 속소에 반영된다고 가정해야 풀림 (물리학과는 운다)
* */

public class D2_1940_go_RC_car {

    final static int CONSTANT_SPEED=0;
    final static int ACCELATION=1;
    final static int DECELATION=2;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n=sc.nextInt();
            int[] op=new int[n];
            int[] vel=new int[n];
            int velocity=0;
            int distance=0;

            for(int i=0;i<n;i++){
                op[i]=sc.nextInt();
                if(op[i]==CONSTANT_SPEED) continue;
                vel[i]=sc.nextInt();
            }


            for(int i=0;i<n;i++){
                switch(op[i]){
                    case CONSTANT_SPEED:{
                        distance+=velocity;
                        break;
                    }
                    case ACCELATION :{
                        velocity+=vel[i];
                        distance+=velocity;
                        break;
                    }
                    case DECELATION:{
                        velocity=Math.max(velocity-vel[i],0);
                        distance+=velocity;
                    }
                }
            }

            System.out.println("#"+test_case+" "+distance);

        }
    }

}
