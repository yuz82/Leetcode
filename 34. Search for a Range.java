/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0]=-1; res[1]=-1;
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                int start=mid, end=mid;
                while(start>low && nums[start-1]==target){ start--; }
                while(end<high && nums[end+1]==target){ end++; }
                res[0]=start; res[1]=end;
                return res;
            }else if(nums[mid]>target){
                high = mid-1;
            }else { low = mid+1; }
        }
        return res;
    }
}
