/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    HashSet<List<Integer>> hs = new HashSet();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList();
        helper(candidates, res, new ArrayList<Integer>(), target, 0);
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, int target, int start){
        if(target==0) {
            List<Integer> tmp = new ArrayList<Integer>(cur);
            if(hs.add(tmp)){
                res.add(tmp); 
            }
            return; 
        }
        for(int i=start;i<nums.length;i++){
            if(nums[i]<=target) { 
                cur.add(nums[i]);
                helper(nums, res, cur, target-nums[i], i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
}
