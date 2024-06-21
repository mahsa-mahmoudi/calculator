package org.example;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.stream.Collectors;
import  java.util.Scanner;

public class Tamrin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("لطفا عدد و عملگر خود را وارد کنید مثلا: 10+2+3");

        String input = scanner.nextLine();
        scanner.close();

        // تجزیه عبارت ورودی به توکن‌ها با در نظر گرفتن عملگرها به عنوان بخشی از توکن‌ها
        String[] tokens = input.split("(\\+|-|\\*)"); // این عبارت منظم باعث می‌شود که عملگرها به عنوان بخشی از توکن‌های جدا شده در نظر گرفته شوند

        double result = Double.parseDouble(tokens[0]); // اولین عدد

        for (int i = 1; i < tokens.length; i++) { // شروع از دومین توکن
            if (!tokens[i].matches("\\d+")) { // بررسی که آیا توکن فعلی یک عدد نیست
                continue; // اگر توکن فعلی یک عملگر باشد، به حلقه بعدی برویم
            }

            double operand = Double.parseDouble(tokens[i]); // گرفتن عدد بعدی

            if (i > 1 &&!tokens[i - 2].matches("[+\\-*/]")) { // بررسی که آیا عملگر قبلی وجود دارد
                System.out.println("Error: Missing operator");
                return;
            }

            switch (tokens[i - 1]) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand!= 0) {
                        result /= operand;
                    } else {
                        System.out.println("Error: Division by zero");
                        return;
                    }
                    break;
                default:
                    System.out.println("Error: Unknown operator");
                    return;
            }
        }

        System.out.println("Result: " + result);
    }
}