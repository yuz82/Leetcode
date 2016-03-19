/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/

//O(n)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int low=0, high=0, sum=0;
        while(high<n){
            sum += nums[high++];
            while(sum>=s){
                min = Math.min(min, high-low);
                sum -= nums[low++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
