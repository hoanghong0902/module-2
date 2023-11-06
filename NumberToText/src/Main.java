import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = scanner.nextInt();
        String text = null;

        if(num <= 10){
            text = Ones(num);
        }else if (num <= 20){
            switch (num){
                case 11:
                    text = "Eleven ";
                    break;
                case 12:
                    text = "Twelve ";
                    break;
                case 13:
                    text = "Thirteen ";
                    break;
                case 14:
                    text = "Fourteen ";
                    break;
                case 15:
                    text = "Fifteen ";
                    break;
                case 16:
                    text = "Sixteen ";
                    break;
                case 17:
                    text = "Seventeen ";
                    break;
                case 18:
                    text = "Eighteen ";
                    break;
                case 19:
                    text = "Nineteen ";
                    break;
                case 20:
                    text = "Twenty ";
                    break;
            }
        } else if (num < 100) {
            int ones = num % 10;
            int tens = num / 10;
            text = Tens(tens) + Ones(ones);
        } else {
            int hundreds = num / 100;
            int ones = num % 10;
            int tens = (num - ones) % 100 / 10;
            text = Hundreds(hundreds) + "and " + Tens(tens) + Ones(ones);
        }
        System.out.println(text);
    }
    public static String Ones (int num) {
        String text = null;
        switch (num) {
            case 1:
                text = "One ";
                break;
            case 2:
                text = "Two ";
                break;
            case 3:
                text = "Three ";
                break;
            case 4:
                text = "Four ";
                break;
            case 5:
                text = "Five ";
                break;
            case 6:
                text = "Six ";
                break;
            case 7:
                text = "Seven ";
                break;
            case 8:
                text = "Eight ";
                break;
            case 9:
                text = "Nine ";
                break;
            case 10:
                text = "Ten ";
                break;
        }
        return text;
    }
    public static String Tens (int num) {
        String text = null;
        switch (num) {
            case 2:
                text = "Twenty ";
                break;
            case 3:
                text = "Thirty ";
                break;
            case 4:
                text = "Forty ";
                break;
            case 5:
                text = "Fifty ";
                break;
            case 6:
                text = "Sixty ";
                break;
            case 7:
                text = "Seventy ";
                break;
            case 8:
                text = "Eighty ";
                break;
            case 9:
                text = "Ninety ";
                break;
        }
        return text;
    }
    public static String Hundreds (int num) {
        String text = null;
        switch (num) {
            case 1:
                text = "One hundred ";
                break;
            case 2:
                text = "Two hundred ";
                break;
            case 3:
                text = "Three hundred ";
                break;
            case 4:
                text = "Four hundred ";
                break;
            case 5:
                text = "Five hundred ";
                break;
            case 6:
                text = "Six hundred ";
                break;
            case 7:
                text = "Seven hundred ";
                break;
            case 8:
                text = "Eight hundred ";
                break;
            case 9:
                text = "Nine hundred ";
                break;
        }
        return text;
    }
}