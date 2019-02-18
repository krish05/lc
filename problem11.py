'''

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.


 |____|_
 |    | |
 ||   | |
 || | | |
 || ||| |
 || |||||
 ||||||||
|||||||||


Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

'''


class Problem11:

    def solve(self, input):
        res, l, r = 0, 0, len(input)-1
        while l<r:
            print(l, r)
            h = min(input[l], input[r])
            res = max(res, h*(r-l))
            l = l + (input[l]==h)
            r = r - (input[r]==h)
            print(h, res, l,r)

        return res

if __name__ == '__main__':
    p11 = Problem11()
    input = [1,2,3,4,5,6]
    print(p11.solve(input))
    input = [1,8,6,2,5,4,8,3,7]
    print(p11.solve(input))
