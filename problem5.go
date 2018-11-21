package main

import "fmt"

func longestPalindrome(s string) string {
    if len(s) == 0 {
        return ""
    }
    if len(s) == 1 {
        return s
    }
    var maxstr = ""
    var i int
    for i=0; i<len(s); i++ {
        maxstr = maxStr(i, i, s, maxstr)
        maxstr = maxStr(i, i+1, s, maxstr)
    }
    return maxstr
}


func maxStr(back int, front int, s string, maxstr string) string {
    for back>=0 && front<len(s) && s[back] == s[front] {
        back--
        front++
    }
    
    if (front-back) > len(maxstr) {
        return s[back+1:front]
    }
    
    return maxstr
}


func main() {
    var maxstr = longestPalindrome("babad")
    fmt.Println(maxstr)
    maxstr = longestPalindrome("cbbbd")
    fmt.Println(maxstr)
    maxstr = longestPalindrome("cbbd")
    fmt.Println(maxstr)
}
