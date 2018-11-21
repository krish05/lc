package leetcode;

import java.util.Scanner;

public class Problem5 {
    
    public String longestPalindrome(String s) {
        String maxStr = "";
        if(s == null || s.length() == 0) {
            return "";
        }
        if(s.length() == 1) {
            return s;
        }
        for(int i=0;i<s.length();i++) {
            maxStr = maxStr(i, i, s, maxStr);
            maxStr = maxStr(i, i+1, s, maxStr);
        }
        return maxStr;
    }
    
    private String maxStr(int back, int front, String s, String maxStr) {
        while(back >= 0 && front < s.length() && s.charAt(back) == s.charAt(front)) {
            back--;
            front++;
        }
        if(front-back > maxStr.length()) {
            System.out.println(front);
            System.out.println(back);
            return s.substring(back+1, front);
        }
        return maxStr;
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String line = scanner.next();
            Problem5 problem = new Problem5();
            System.out.println(problem.longestPalindrome(line));
        }
        scanner.close();
    }
    
}
