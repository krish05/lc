package leetcode;

import java.util.Scanner;

public class Problem7 {
    public int reverse(int x) {
        long revInt = 0;
        int negative = (x<0) ? -1: 1;
        x = Math.abs(x);
        while(x>=1) {
            int remainder = x%10;
            long newRevInt = revInt*10 + remainder;
            if(newRevInt < 0 || newRevInt > Integer.MAX_VALUE) {
                return 0;
            }
            revInt = (int)newRevInt;
            x = x/10;
        }
        return (int)revInt * negative;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = scanner.nextInt();
            Problem7 problem = new Problem7();
            System.out.println(problem.reverse(n));
            System.out.println(Integer.MAX_VALUE);
        }
        scanner.close();
    }
}
