/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/


//dynamic programming 
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}


//O(nlogn) binary search
public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
