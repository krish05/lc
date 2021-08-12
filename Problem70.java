class Solution {
    public int climbStairs(int n) {
        int stepsFromHere =1, stepsFromNextStep=1;
        for(int i=n-2;i>=0; i--) {
            int temp = stepsFromHere;
            stepsFromHere = stepsFromHere+stepsFromNextStep;
            stepsFromNextStep = temp;
        }
        return stepsFromHere;
    }
}
