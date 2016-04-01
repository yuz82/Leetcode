/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

*/
//Greedy O(n)
public class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        int max = nums[0];
        for(int i=1;i<n;i++){
            if(i<=max && i+nums[i] > max){
                max = i + nums[i];
            }
        }
        return max>=n-1;
    }
}

//O(n)  DP
public class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && j+nums[j]>=i){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}
