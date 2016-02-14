/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

//recursive
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n<1 || k<1){ return res; }
        helper(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int start, int n, int k){
        if(k==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=start;i<=n;i++){
            list.add(i);
            helper(res, list, i+1, n, k-1);
            list.remove(list.size()-1);
        }
    }
}
