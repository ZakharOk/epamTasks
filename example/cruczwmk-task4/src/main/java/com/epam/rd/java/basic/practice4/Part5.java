package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
        request();
    }
    private static void request(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String req = sc.nextLine();
            ResourceBundle bundleRu = ResourceBundle.getBundle("resources", new Locale("ru"));
            ResourceBundle bundleEn = ResourceBundle.getBundle("resources", new Locale("en"));
            switch (req) {
                case "apple ru":
                    System.out.println(bundleRu.getString("apple"));
                    request();
                    break;
                case "apple en":
                    System.out.println(bundleEn.getString("apple"));
                    request();
                    break;
                case "table ru":
                    System.out.println(bundleRu.getString("table"));
                    request();
                    break;
                case "table en":
                    System.out.println(bundleEn.getString("table"));
                    request();
                    break;
                case "stop":
                    break;
                default:
                    System.out.println("Incorrect input");
                    request();
                    break;
            }
        }
    }

}
