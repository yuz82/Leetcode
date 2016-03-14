/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
*/

//to be continued...

//two pointers && sort
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int start = 0, end = 0;
        List<Integer> res = new ArrayList();
        while(end<n){
            while(end<n && nums[end]==nums[start]){ end++; }
            if((end-start)>n/3) { res.add(nums[start]); }
            start = end;
        }
        return res;
    }
}
