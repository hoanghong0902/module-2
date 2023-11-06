package com.codegym;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Hãy nhập x: ");
            int x = scanner.nextInt();
            System.out.println("Hãy nhập y: ");
            int y = scanner.nextInt();
            System.out.println("Hãy nhập x: ");
            int z = scanner.nextInt();
            illegalTriangleException(x,y,z);
        } catch (Exception e){
            e.printStackTrace();
        }


    }
    private static void illegalTriangleException(int x, int y, int z){
        if ((x + y > z) && (x + z > y) && (y + z > x)
            && x > 0 && y > 0 && z > 0){
            System.out.println("Day la 3 canh cua tam giac");
        } else {
            throw new RuntimeException("Day khong phai la 3 canh cua tam giac");
        }
    }
}