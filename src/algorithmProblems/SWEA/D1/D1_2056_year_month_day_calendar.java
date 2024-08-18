package SWEA.D1;

import java.util.Scanner;

public class D1_2056_year_month_day_calendar {

    public static void main(String args[])throws Exception{

        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        sc.nextLine();

        for(int test_case=1;test_case<=T;test_case++){
            String ans="";
            String input=sc.nextLine();
            if(input.length()!=8) ans="-1";
            else{
                int year=Integer.parseInt(input.substring(0,4));
                int month=Integer.parseInt(input.substring(4,6));
                int day=Integer.parseInt(input.substring(6));
                switch(month){
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12: {
                        if(day>31||day<1) ans="-1";
                        else ans=String.format("%04d/%02d/%02d",year,month,day);
                        break;
                    }
                    case 4:
                    case 6:
                    case 9:
                    case 11:{
                        if(day>30||day<1) ans="-1";
                        else ans=String.format("%04d/%02d/%02d",year,month,day);
                        break;
                    }
                    case 2:{
                        if(day>28||day<1) ans="-1";
                        else ans=String.format("%04d/%02d/%02d",year,month,day);
                        break;
                    }
                    default : ans="-1";

                }
            }
            System.out.println("#"+test_case+" "+ans);

        }
    }
}
