package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static CharSequence mmm;

    public static void main(String[] args )
    {
        Scanner num= new Scanner(System.in);
        System.out.println( "لطفا یک عبارت ریاضی وارد کنید :" );
        String input1 = num.nextLine();
        String input =input1 + '+';
        char[] charArr=input.toCharArray();
        String str = "";
        float result=0;
        for (int i =0; i<input.length();i++){
            if (charArr[i]=='0'||charArr[i]=='1'||charArr[i]=='2'||charArr[i]=='3'||charArr[i]=='4'||charArr[i]=='5'||charArr[i]=='6'||charArr[i]=='7'||charArr[i]=='8'||charArr[i]=='9'){
                str += (charArr[i]);
                continue;
            } else if (charArr[i]=='+'||charArr[i]=='-'||charArr[i]=='*'||charArr[i]=='/') {
                String mmm = str;
                switch (charArr[i]){
                    case '+' :
                        result += Integer.parseInt(mmm);
                        break;
                    case '-' :
                        result -= Integer.parseInt(mmm);
                        break;
                    case '*' :
                        result *= Integer.parseInt(mmm);
                        break;
                }
            } else {
                System.out.println("رشته صحیح نمی باشد ");
            }
            str="";
        }
        System.out.println(result);
    }
}
