/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k,n, 1, 0, new ArrayList<Integer>());
        return res;
    }
    
    public void helper(int k, int n, int num, int sum, List<Integer> list){
        if(list.size()==k){
            if(sum==n){ res.add(new ArrayList<Integer>(list)); }
            return;
        }
        if(num>n-sum){ return; }
        for(int i=num;i<=9;i++){
            list.add(i);
            helper(k,n,i+1,sum+i,list);
            list.remove(list.size()-1);
        }
    }
}
