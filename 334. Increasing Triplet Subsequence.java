/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
*/

//O(n) time and O(1) space solution
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0){ return false; }
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]<=small) { small = nums[i]; }
            else if(nums[i]<=big) { big = nums[i]; }
            else return true;
        }
        return false;
    }
}

//O(n^2) time and O(n) space solution
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0){ return false; }
        int[] dp = new int[n];
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=i-1;j>-1;j--){
                if(nums[j] < nums[i]){
                    max = Math.max(max, dp[j]+1);
                    if(max==2){ return true; }
                }
            }
            dp[i] = max;
        }
        return false;
    }
}
