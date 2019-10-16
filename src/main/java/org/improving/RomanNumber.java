package org.improving;

import java.util.Scanner;
import java.util.TreeMap;

public class RomanNumber {

    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        while (true) {
            var input = RomanNumber.getInteger(scanner);
            if (!RomanNumber.isValid(input)) {
                System.out.println("Please enter a valid integer less than 1,000,000");
                continue;
            }
            var roman = toRoman(input);
            System.out.println(roman);
        }
    }

    public final static String toRoman(int number) {
        // Return the greatest key less than or equal to the given key.
        int l =  map.floorKey(number);

        // If the number equals the floorKey, return the associated Roman Numeral
        if ( number == l ) {
            return map.get(number);
        }

        // Otherwise store the floorKey and find the next floorKey for the difference
        return map.get(l) + toRoman(number-l);
    }

    public static boolean isValid(int number) {
        return number > 0 && number <= 1000000;
    }

    public static int getInteger(Scanner scanner) {
        System.out.print("> ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter an integer.");
            System.out.print("> ");
            scanner.nextLine();
        }
        int num = scanner.nextInt();
        return num;
    }

}