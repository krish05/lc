'''
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:

All given inputs are in lowercase letters a-z.
'''
class Problem14:

    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        strlist = list(strs)
        result=""
        i=0
        min_size = 1000
        for str in strlist:
            if len(str) < min_size:
                min_size = len(str)

        if min_size == 0:
            return ""

        if len(strlist) == 0:
            return ""

        for i in range(min_size):
            not_same = False
            ch = strlist[0][i]
            for j in range(1, len(strlist)):
                if ch != strlist[j][i]:
                    not_same = True
                    break
            if not not_same:
                result += ch
            else:
                break
        return result

if __name__ == '__main__':
    p14 = Problem14()
    print(p14.longestCommonPrefix({'flower','flow','flight'}))
    print(p14.longestCommonPrefix({'aca','cba'}))


