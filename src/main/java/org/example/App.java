package org.example;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("لطفا یک عبارت ریاضی وارد کنید: ");
        String input = scanner.nextLine();
        scanner.close();

        // تعریف الگوی منظم برای اعداد و عملگرها
        Pattern pattern = Pattern.compile("(\\d+)\\s*([-+*/])\\s*(\\d+)");
        Matcher matcher = pattern.matcher(input);

        double result = 0;
        while (matcher.find()) {
            double num1 = Double.parseDouble(matcher.group(1));
            String operator = matcher.group(2);
            double num2 = Double.parseDouble(matcher.group(3));
            result=num1;
            switch (operator) {
                case "+":
                    result += num2;
                    break;
                case "-":
                    result -= num2;
                    break;
                case "*":
                    result *= num2;
                    break;
                case "/":
                    if (num2!= 0) {
                        result /= num2;
                    } else {
                        System.out.println("خطا: تقسیم بر صفر!");
                        return; // خروج از برنامه
                    }
                    break;
            }
        }

        System.out.printf("نتایج محاسبات: %.2f%n", result);
    }
}