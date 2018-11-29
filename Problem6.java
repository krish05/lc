package leetcode;

import java.util.Scanner;

public class Problem6 {
    
    public String zigzag(String line, int size) {
        int length = line.length();
        
        if(size <= 1) {
            return line;
        }
        
        StringBuffer[] strArray = new StringBuffer[size];
        for(int i=0; i<size; i++) {
            strArray[i] = new StringBuffer();
        }
        boolean down = true;
        int current = 0;
        for(int i=0; i<length; i++) {
            strArray[current].append(line.charAt(i));
            if(current == size-1) {
                down = false;
            } else if(current == 0) {
                down = true;
            }
            if(down) {
                current++;
            } else {
                current--;
            }
        }
        StringBuffer result = new StringBuffer();
        for(int i=0; i<size; i++) {
            result.append(strArray[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String line = scanner.next();
            int size = scanner.nextInt();
            Problem6 problem = new Problem6();
            System.out.println(problem.zigzag(line, size));
        }
        scanner.close();
    }
}
