/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/

//hashset
public class Solution {
    List<List<Integer>> res = new ArrayList();
    HashSet<List<Integer>> hs = new HashSet();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        if(nums==null) { return res; } 
        res.add(new ArrayList<Integer>());
        int n = nums.length;
        for(int i=0;i<n;i++){
            int size = res.size();
            for(int j=0;j<size;j++){
                List<Integer> list = new ArrayList(res.get(j));
                list.add(nums[i]);
                if(hs.add(list)){
                    res.add(list);
                }
            }
        }
        return res;
    }
}

//recursion
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) { return res; }
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        helper(nums, res, 0, new ArrayList<Integer>());
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, int i, List<Integer> list){
        for(int k=i;k<nums.length;k++){
            list.add(nums[k]);
            if(!res.contains(list)) { res.add(new ArrayList<Integer>(list)); }
            helper(nums, res, k+1, list);
            list.remove(list.size()-1);
        }
    }
}
