/*
Given an unsorted array nums, reorder it in-place such that

nums[0] <= nums[1] >= nums[2] <= nums[3]....
 Notice

Please complete the problem in-place.
*/

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        int n = nums.length;
        if(nums==null || n==0) { return; }
        for(int i=0;i<n;i++){
            if(i%2==0){
                if(i!=0 && nums[i-1]<nums[i]) { swap(nums, i); }
            }else{
                if(nums[i-1]>nums[i]) { swap(nums, i); }
            }
        }
        
    }
    
    public void swap(int[] nums, int i){
        int tmp = nums[i];
        nums[i] = nums[i-1];
        nums[i-1] = tmp;
    }
}
