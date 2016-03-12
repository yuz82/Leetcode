/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        if(nums==null || n==0) { return 0; }
        int max = nums[0];
        int min = nums[0];
        int res = max;
        for(int i=1;i<n;i++){
            if(nums[i]<0){ //swap
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max*nums[i], nums[i]);
            min = Math.min(min*nums[i], nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
