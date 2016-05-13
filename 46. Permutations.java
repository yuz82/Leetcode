/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int n : nums){
            int size = res.size();
            for(;size>0;size--){
                List<Integer> r = res.pollFirst();
                for(int i=0;i<=r.size();i++){
                    List<Integer> tmp = new ArrayList<Integer>(r);
                    tmp.add(i,n);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
    
}



//recursive
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int n = nums.length;
        if(nums==null || n==0) { return res; }
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<Integer>());
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> list){
        if(list.size()==nums.length) { res.add(new ArrayList<Integer>(list)); return; }
        for(int j=0;j<nums.length;j++){
            if(list.contains(nums[j])) { continue; }
            list.add(nums[j]);
            helper(nums,res, list);
            list.remove(list.size()-1);
        }
    }
}
