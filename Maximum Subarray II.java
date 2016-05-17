/*
Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

Note: The subarray should contain at least one number

Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int n = nums.size();
        if(n==0) { return 0; }
        int[] left = new int[n];
        int[] right = new int[n];
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum = Math.max(nums.get(i), sum+nums.get(i));
            max = Math.max(max, sum);
            left[i] = max;
        }
        sum = 0; max = Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            sum = Math.max(nums.get(i), sum+nums.get(i));
            max = Math.max(max, sum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            max = Math.max(max, left[i] + right[i+1]);
        }
        return max;
    }
}

