/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

//test case: [1,1,3,1]  target: 3
public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            if(start!=end?nums[start]==nums[end]:false || start+1<end?nums[start]==nums[start+1]:false) { ++start;continue;}
            if(start<end-1?nums[end]==nums[end-1]:false) { --end;continue;}
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if(nums[mid] > nums[end]){ //mid in the reversed half
                if(target<=nums[mid] && target>nums[end]){ //target in the smaller half
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target>=nums[mid] && target<=nums[end]){ //target in the second half
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}

public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }

        return false;
    }

