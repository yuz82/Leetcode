/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example,
Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len==0||len==1){
            return len;
        }
        int count = 1;
        int cur = nums[0];
        for(int i=1;i<len;i++){
            if(nums[i]!=cur){
                nums[count++]=nums[i];
                cur = nums[i];
            }
        }
        return count;
    }
}


//round2
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0){
            return 0;
        }
        int count = 0;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[count]){
                continue;
            }
            nums[++count] = nums[i];
        }
        return ++count;
    }
}

