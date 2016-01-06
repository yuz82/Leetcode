/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

//binary search
public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        return getMin(nums, 0, n-1);
    }
    
    public int getMin(int[] nums, int start, int end){
        while(start<end){
            if(nums[start]<nums[end]){
                return nums[start];
            }else{
                int mid = start+(end-start)/2;
                if(nums[mid]<nums[end]){
                    return getMin(nums, start, mid);
                }else{
                    return getMin(nums, mid+1, end);
                }
            }
        }
        return nums[start];
    }
    
}

//solution2
public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        for(int i=1;i<len;i++){
            if(nums[i]<nums[i-1]){
                return nums[i];
            }
        }
        return nums[0];
    }
}
