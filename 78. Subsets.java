/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

//combination
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(nums==null || n==0) { return res; }
        Arrays.sort(nums);
        for(int i=0;i<=n;i++){
            res.addAll(combination(nums,n,i));
        }
        return res;
    }
    
    public List<List<Integer>> combination(int[] nums, int n, int k){
        if(k==0 || k==n){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<k;i++){
                list.add(nums[i]);
            }
            return new ArrayList<>(Arrays.asList(list));
        }
        List<List<Integer>> res = combination(nums,n-1,k-1);
        res.forEach(e -> e.add(nums[n-1]));
        res.addAll(combination(nums,n-1,k));
        return res;
    }
}
