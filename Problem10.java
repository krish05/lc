package leetcode;

/***
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false


 * @author kriprakash
 *
 */
public class Problem10 {

    public boolean isMatch(String s, String p) {
        //System.out.println(s+"\t"+p);
        boolean match[][] = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        //printMatchArray(match, "Init");
        for(int i=1; i<s.length()+1; i++) {
            match[i][0] = false;
        }
        //printMatchArray(match, "I init");
        for(int j=1; j<p.length()+1; j++) {
            match[0][j] = (p.charAt(j-1)=='*') ? match[0][j-2]: false;
        }
        //printMatchArray(match, "J init");
        for(int i=1;i<s.length()+1; i++) {
            for(int j=1; j<p.length()+1; j++) {
                if(p.charAt(j-1) == s.charAt(i-1)) {
                    match[i][j] = match[i-1][j-1];
                } else if(p.charAt(j-1) == '.') {
                    match[i][j] = match[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {
                   /* match[i][j] = ((j>1)? ((s.charAt(i-1) == p.charAt(j-2) ||
                                            p.charAt(j-2) == '.')?match[i-1][j]: false) : false ||
                                    match[i][j-1] ||
                                    ((j>2)?match[i][j-2]:false));*/
                    match[i][j] = match[i][j-1] || 
                                        ((j>1)? (s.charAt(i-1) == p.charAt(j-2) ? match[i-1][j]:false) :false) ||
                                        ((j>1)? ('.' == p.charAt(j-2) ? match[i-1][j]:false) :false) ||
                                        match[i][j-2];
                    /*match[i][j] = match[i-1][j] ||
                                    match[i][j-1] ||
                                    ((j>2)?match[i][j-2]:false);*/
                } else {
                    match[i][j] = false;
                }
            }
        }
        //printMatchArray(match, "matrix init");
        //printPerfectMatch(match, s, p);
        return match[s.length()][p.length()];
    }

    private void printPerfectMatch(boolean match[][], String s, String p) {
        for(int i=0; i<match.length; i++) {
            for(int j=0; j<match[i].length; j++) {
                System.out.print("["+match[i][j]+"  "+s.substring(0, i)+"," + p.substring(0, j)+"]\t");
            }
            System.out.println();
        }
        
        System.out.println();
    }
    private void printMatchArray(boolean match[][], String message) {
        if(false) {
            System.out.println(message);
            for(int i=0;i<match.length; i++) {
                for(int j=0; j<match[i].length; j++) {
                    System.out.print(match[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        Problem10 problem = new Problem10();
        /*System.out.println(problem.isMatch("aa","a"));
        System.out.println(problem.isMatch("aa","a*"));
        System.out.println(problem.isMatch("aa","ab"));
        System.out.println(problem.isMatch("ab",".*"));
        System.out.println(problem.isMatch("aab","c*a*b"));
        System.out.println(problem.isMatch("mississippi","mis*is*p*."));*/
        System.out.println(problem.isMatch("ab",".*"));
        System.out.println(problem.isMatch("aa", "a*"));
        System.out.println(problem.isMatch("aab","c*a*b"));
        System.out.println(problem.isMatch("mississippi", "mis*is*ip*."));
        System.out.println(problem.isMatch("mississippi","mis*is*p*."));
    }
}
