import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        double rate = 23000;
//        System.out.println("Enter USD: ");
//        float usd = scanner.nextFloat();
//        long vnd = (long) (usd * rate);
//        System.out.println("VND = " + vnd);
        String[] x = new String[]{"John", "Chris", "Mark", "PJ"};

        if (x.length == 4) {
            System.out.print(x[x.length-3]);
        } else {
            System.out.print("Codegym");
        }

    }
    public static int[] swap(int[] arr) {
        // code here
        int temp = arr[0];
        arr[0] = arr[arr.length-1];
        arr[length-1] = temp;
        return arr;
    }
}