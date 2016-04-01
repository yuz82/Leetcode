/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.

*/

public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n<2) { return 0; }
        int start = 0, end = 0, jump = 0, far = 0;
        while(end<n-1){   //********  -1
            jump++;
            for(int i=start;i<=end;i++){
                if(i+nums[i]>far){
                    far = i + nums[i];
                }
            }
            start = end + 1; //******  +1
            end = far;
        }
        return jump;
    }
}

//O(n^2) DP
public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(dp[j]!=Integer.MAX_VALUE && j+nums[j]>=i){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n-1]==Integer.MAX_VALUE?-1:dp[n-1];
    }
}
