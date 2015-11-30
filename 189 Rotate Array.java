/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

//O(n) space
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int offset = k%n;
        if(offset!=0){
            int[] arr = Arrays.copyOf(nums, n); 
            for(int i=0;i<n;i++){
                if(i+offset<n){
                    nums[i+offset] = arr[i];
                }else{
                    nums[i+offset-n] = arr[i];
                }
            }
        }
    }
}

//O(1) space  reverse
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int offset = k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, offset-1);
        reverse(nums, offset, n-1);
    }
    
    public void reverse(int[] nums, int start, int end){
        while(start<end){
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
