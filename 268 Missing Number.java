/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
*/

public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int xor = 0;
        int i=0;
        for(;i<len;i++){
            xor ^= nums[i] ^ i;
        }
        return xor ^ i;
    }
}
