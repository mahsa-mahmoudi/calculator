package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CalculatorSecond {
    public static void main(String[] args ) {
        Scanner num = new Scanner(System.in);
        System.out.println("لطفا یک عبارت ریاضی وارد کنید :");
        String input1 = num.nextLine();
        String input = input1+'+';

        double result=0;

///////////////////////////////////////////////////////////////////////////////////////

        String operatorPattern = "\\s*(\\+|-|\\*|/)";
        String numberPattern = "\\d+(?=\\s*(\\+|-|\\*|/))";

        Pattern operatorPatternObj = Pattern.compile(operatorPattern);
        Pattern numberPatternObj = Pattern.compile(numberPattern);

        Matcher operatorMatcher = operatorPatternObj.matcher(input);
        Matcher numberMatcher = numberPatternObj.matcher(input);


        List<String> operators = new ArrayList<>();
        List<Double> numbers = new ArrayList<>();


        while (operatorMatcher.find()) {
            if (numberMatcher.find()) {
                numbers.add(Double.parseDouble(numberMatcher.group()));
            }
            operators.add(operatorMatcher.group().trim()); // اضافه کردن عملگر به لیست
        }

        // بررسی و اجرای عملگرها بر اساس ترتیب آنها در لیست
        for (int i = 0; i < operators.size(); i++) {
            switch (operators.get(i)) {
                case "+":
                    result += numbers.get(i);
                    break;
                case "-":
                    result -= numbers.get(i);
                    break;
                case "*":
                    result *= numbers.get(i);
                    break;
                case "/":
                    if (numbers.get(i)!= 0) {
                        result /= numbers.get(i);
                    } else {
                        System.out.println("Error: Division by zero.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Unknown operator.");
                    return;
            }
        }

        System.out.println("Result: " + result);
    }
}