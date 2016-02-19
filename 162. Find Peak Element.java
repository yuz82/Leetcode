/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

Note:
Your solution should be in logarithmic complexity.
*/

//O(logn), binary search, iteration
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0){ return -1; }
        int start=0, end=n-1;
        while(start<end){
            int mid1 = (end+start)/2;
            int mid2 = mid1+1;
            if(nums[mid1]<nums[mid2]){
                start = mid2;
            }else{
                end = mid1;
            }
        }
        return start;
    }
}

//O(n)
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0){ return -1; }
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i]){
                return i-1;
            }
        }
        return n-1;
    }
}

//O(n)
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0){ return -1; }
        for(int i=0;i<n;i++){
            if((i>1?nums[i]>nums[i-1]:true) && (i+1<n?nums[i]>nums[i+1]:true)){
                return i;
            }
        }
        return -1;
    }
}
