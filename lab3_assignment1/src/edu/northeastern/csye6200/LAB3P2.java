package edu.northeastern.csye6200;
import java.util.Scanner;

public class LAB3P2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of values: ");
        int x = input.nextInt();
        int[] y = new int[x];
        System.out.print("Enter the numbers: ");
        for (int i = 0; i < x; i++) {
            y[i] = input.nextInt();
        }
        if (isConsecutiveFour(y)) {
            System.out.println("The list has consecutive fours.");
        } else {
            System.out.println("The list has no consecutive fours.");
        }
        input.close();
    }

	public static boolean isConsecutiveFour(int[] values) {
		if (values.length < 4) {
            return false;
        }
        for (int i = 0; i <= values.length - 4; i++) {
            if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3]) {
                return true;
            }
        }
        return false;
    }

}

