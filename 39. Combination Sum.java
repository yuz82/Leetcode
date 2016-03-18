/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList();
        helper(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, int target, int start){
        if(target==0) { res.add(new ArrayList<Integer>(cur)); return; }
        for(int i=start;i<nums.length;i++){
            if(nums[i]<=target){
                cur.add(nums[i]);
                helper(nums, res, cur, target-nums[i], i);
                cur.remove(cur.size()-1);
            }
        }
    }
}
