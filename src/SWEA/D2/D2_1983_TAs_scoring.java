package SWEA.D2;

import java.util.*;

public class D2_1983_TAs_scoring {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int studentCount=sc.nextInt();
            int studentIndex=sc.nextInt();
            String grade="";
            double[][] scores=new double[studentCount][2];

            for(int i=0;i<studentCount;i++){
                int middleExam=sc.nextInt();
                int finalExam=sc.nextInt();
                int task=sc.nextInt();
                double total=middleExam*0.35+finalExam*0.45+task*0.2;
                scores[i][0]=i;
                scores[i][1]=total;
            }
            //여기가 문제였음! o2[1]-o1[1]을 int로 변환하는 과정에서 -0.001같은게 음수가 아닌 0으로 처리되서 sort가 잘 안됐다!
            Comparator<double[]> c= (o1, o2) -> {
                double sub=o2[1] - o1[1];
                if(sub==0) return 0;
                else return (o2[1] - o1[1] > 0.0) ? 1 : -1;
            };

		    Arrays.sort(scores,c);

            for(int i=0;i<studentCount;i++){
                if(scores[i][0]==studentIndex-1){
                    switch(i/(studentCount/10)){
                        case 0: grade="A+";
                            break;
                        case 1: grade="A0";
                            break;
                        case 2: grade="A-";
                            break;
                        case 3: grade="B+";
                            break;
                        case 4: grade="B0";
                            break;
                        case 5: grade="B-";
                            break;
                        case 6: grade="C+";
                            break;
                        case 7: grade="C0";
                            break;
                        case 8: grade="C-";
                            break;
                        default: grade="D0";

                    }
                    break;
                }
            }
            System.out.println("#"+test_case+" "+grade);

        }
    }
}
