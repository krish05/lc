package leetcode;

import java.util.Scanner;

public class Problem8 {

    public int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        boolean negative = false;
        if(str.startsWith("-")) {
            negative = true;
            str = str.substring(1);
        } else if(str.startsWith("+")) {
            str = str.substring(1);
        }
        if(str == null || str.length() == 0) {
            return 0;
        }
        if(str.charAt(0) >='0' && str.charAt(0) <='9') {
            int charAt = 0;
            long number = 0;
            while(charAt < str.length() && str.charAt(charAt) >= '0' && str.charAt(charAt) <= '9') {
                number = number*10 + str.charAt(charAt)-'0';
                if(number < 0 || number > Integer.MAX_VALUE) {
                    return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                charAt++;
            }
            return (int)(negative? -1*number : number);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String input = scanner.next();
            Problem8 problem = new Problem8();
            System.out.println(problem.myAtoi(input));
        }
        scanner.close();
    }
    
}
