package leetcode;

import java.util.Scanner;

/***
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true

Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


1000021



Follow up:

Coud you solve it without converting the integer to a string?

 * @author kriprakash
 *
 */
public class Problem9 {

    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        if(x<10) {
            return true;
        }
        if(x<100 && x%11 == 0) {
            return true;
        }
        int lastDigit = x%10;
        int log10X = getBase10(x);
        int firstDigit = (int)Math.floor(x/(Math.pow(10, log10X)));
        if(firstDigit != lastDigit) {
            return false;
        }
        int newNumber = x%(int)Math.pow(10, log10X)/10;
        int newNumberBase10 = getBase10(newNumber);
        int diff = log10X-newNumberBase10;
        if(diff>2) {
            if((newNumber%(int)Math.pow(10,(diff-2))) != 0) {
                return false;
            } else {
                newNumber = newNumber/(int)Math.pow(10, diff-2);
            }
        }
        
        return isPalindrome(newNumber);
    }

    public int getBase10(int n) {
        return (int)Math.floor(Math.log10((double)n));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int input = scanner.nextInt();
            Problem9 problem = new Problem9();
            System.out.println(problem.isPalindrome(input));
        }
        scanner.close();
    }
}
