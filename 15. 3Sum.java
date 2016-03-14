/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

//two pointers
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i==0 || (i>0&&nums[i]!=nums[i-1])){
                int target = 0 - nums[i];
                int low = i+1, high = n-1;
                while(low < high){
                    if(nums[low]+nums[high]==target){
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low<high && nums[low]==nums[low+1]){ low++; }
                        while(low<high && nums[high]==nums[high-1]) { high--; }
                        low++; high--;
                    }else if(nums[low]+nums[high]<target) { low++; }
                    else{ high--; }
                }
            }
        }
        return res;
    }
}
