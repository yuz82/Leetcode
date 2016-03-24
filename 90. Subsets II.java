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

