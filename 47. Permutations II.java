/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

//backtracking
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> res = new  LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int n : nums){
            int size = res.size();
            HashSet<String> hs = new HashSet<>();
            for(; size>0; size--){
                List<Integer> r = res.pollFirst();
                for(int i=0;i<=r.size();i++){
                    List<Integer> tmp = new ArrayList<Integer>(r);
                    tmp.add(i,n);
                    if(hs.add(tmp.toString())){
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }
}
