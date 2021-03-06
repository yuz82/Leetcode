/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

public class Solution {
    public void sortColors(int[] nums) {
        if(nums!=null){
            int left = 0;
            int right = nums.length-1;
            for(int i=0;i<=right;i++){
                while(nums[i]==2&&i<right){
                    int tmp = nums[i];
                    nums[i] = nums[right];
                    nums[right--] = tmp;
                }
                while(nums[i]==0&&i>left){
                    int tmp = nums[i];
                    nums[i] = nums[left];
                    nums[left++] = tmp;
                }
            }
        }
    }
}

//solution 2
public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0){ return; }
        int left = 0;
        int right = n-1;
        for(int i=0;i<=right;i++){
            if(i>left && nums[i]==0){
                swap(left, i, nums);
                left++;
                i--;
            }
            if(i<right && nums[i]==2){
                swap(right, i, nums);
                right--;
                i--;
            }
            
            
        }
    }
    
    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
