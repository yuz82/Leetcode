/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and 
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

//dynamic programming
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int rob = 0; //the max value if rob the current house
        int notrob = 0; //the max value if not rob the current house
        for(int i=0;i<len;i++){
            int currob = notrob + nums[i]; //the value if rob the current house
            notrob = Math.max(rob, notrob); //the max value for (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }

}
