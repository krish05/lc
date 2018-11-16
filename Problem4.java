package leetcode;

import java.util.Scanner;

public class Problem4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        
        if(x>y) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = x;
        while(low<=high) {
            int partitionX = (low+high)/2;
            int partitionY = (x+y+1)/2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE: nums1[partitionX-1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE: nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE: nums2[partitionY-1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE: nums2[partitionY];
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((x+y)%2 == 0) {
                    return (double)(Math.max(maxLeftY, maxLeftX) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)(Math.max(maxLeftY, maxLeftX));
                }
            } else if(maxLeftX > minRightY) {
                high = partitionX-1;
            } else {
                low = partitionX+1;
            }
        }
        
        throw new IllegalArgumentException();
    }
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String line = scanner.next();
            String[] parts = line.split(",");
            int[] n1 = new int[parts.length];
            int i=0;
            for(String part: parts) {
                n1[i] = Integer.valueOf(part);
                i++;
            }
            line = scanner.next();
            parts = line.split(",");
            int[] n2 = new int[parts.length];
            i=0;
            for(String part: parts) {
                n2[i] = Integer.valueOf(part);
                i++;
            }
            System.out.println(findMedianSortedArrays(n1, n2));
        }
        scanner.close();
    }
}
