/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        int len = nums.length;
        for(int i=1;i<len;++i){
            maxEndingHere = Math.max(nums[i], maxEndingHere+nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}

//dynamic programming
public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

