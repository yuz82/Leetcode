/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

//two dp
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0) { return 0; }
        if(n==1) { return nums[0]; }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = nums[0]; dp1[1] = Math.max(dp1[0], nums[1]);
        dp2[0] = 0; dp2[1] = nums[1];
        for(int i=2;i<n;i++){
            dp1[i] = Math.max(dp1[i-2]+nums[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2]+nums[i], dp2[i-1]);
        }
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}
