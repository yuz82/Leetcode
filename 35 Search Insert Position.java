/*
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low+1 < high){
            int mid = low + (high-low)/2;
            if(nums[mid]>=target) { high = mid; }
            else{ low = mid; }
        }
        if(nums[low]>=target) { return low; }
        if(nums[high]>=target) { return high; }
        return high+1;
    }
}


public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(!(nums[i]<target)){
                return i;
            }
        }
        return len;
    }
}
