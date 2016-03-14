/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[n-1];
        for(int i=0;i<n-2;i++){
            int low = i+1, high = n-1; 
            while(low < high){
                int sum = nums[low]+nums[high]+nums[i];
                if(Math.abs(sum-target) < Math.abs(res-target)){
                    res = sum;
                }
                if(sum > target) { high--; }
                else{ low++; }
            }
        }
        return res;
    }
}
