package edu.northeastern.csye6200;
import java.util.Scanner;

public class LAB3P1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a credit card number as a long integer or 0 to exit: ");
            long cardDetails = input.nextLong();
            if (cardDetails == 0) {
                System.out.println("Thank You!");
                break;
            }
            if (isValid(cardDetails)) {
                System.out.println(cardDetails + " is valid");
            } else {
                System.out.println(cardDetails + " is invalid");
            }
        }
        input.close();
	}

	public static boolean isValid(long number) {
		return (getSize(number) >= 13 && getSize(number) <= 16) && 
				(prefixMatched(number, 4) || prefixMatched(number, 5) || 
						prefixMatched(number, 37) || prefixMatched(number, 6)) && 
				((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
	}

	public static int sumOfDoubleEvenPlace(long number) {
		int sum = 0;
        String num = Long.toString(number);
        for (int i = num.length() - 2; i >= 0; i -= 2) {
            sum = sum + getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        }
        return sum;
	}

	public static int getDigit(int number) {
		if (number < 9)
            return number;
        return number / 10 + number % 10;
	}

	public static int sumOfOddPlace(long number) {
		int sum = 0;
        String num = Long.toString(number);
        for (int i = num.length() - 1; i >= 0; i -= 2) {
            sum = sum + Integer.parseInt(num.charAt(i) + "");
        }
        return sum;
	}

	public static boolean prefixMatched(long number, int d) {
		return getPrefix(number, getSize(d)) == d;
	}

	public static int getSize(long d) {
		return Long.toString(d).length();
	}

	public static long getPrefix(long number, int k) {
		String x = Long.toString(number);
        if (x.length() > k) {
            return Long.parseLong(x.substring(0, k));
        }
        return number;
	}
}
