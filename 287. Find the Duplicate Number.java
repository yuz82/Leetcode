/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

*/

//similar to "Linked List Cycle II"
public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(nums==null || n<2) { return -1; }
        int walker = nums[0];
        int runner = nums[0];
        do{
            walker = nums[walker];
            runner = nums[nums[runner]];
        }while(walker!=runner);
        runner = nums[0];
        while(walker!=runner){
            walker = nums[walker];
            runner = nums[runner];
        }
        return walker;
    }
    
}

//sort, modified array
public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0) { return -1; }
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
    
}
