/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        int n = nums.length;
        if(nums==null || n==0) { return res; }
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i==0 || i>0&&nums[i]!=nums[i-1]){
                for(int j=i+1;j<n;j++){
                    if(j==i+1 || j>i+1&&nums[j]!=nums[j-1]){
                        int sum = target - nums[i] - nums[j];
                        int low = j+1, high = n-1;
                        while(low < high){
                            if(nums[low]+nums[high]==sum){
                                res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while(low<high && nums[low]==nums[low+1]) { low++; }
                                while(low<high && nums[high]==nums[high-1]) { high--; }
                                low++; high--;
                            }else if(nums[low]+nums[high]>sum){ high--; }
                            else { low++; }
                        }
                    }
                }
            }
        }
        return res;
    }
}
