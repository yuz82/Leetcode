/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/


//time limited exceed solution
public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int j=1;j<=n;j++){
            int size = res.size();
            for(;size>0;size--){
                List<Integer> r = res.remove(0);
                for(int i=0;i<=r.size();i++){
                    List<Integer> tmp = new ArrayList<Integer>(r);
                    tmp.add(i,j);
                    res.add(tmp);
                    if(j==n && res.size()==k){
                        break;
                    }
                }
            }
        }
        if(k>res.size()){
            return "-1";
        }
        List<Integer> tmp = res.get(k-1);
        int len = tmp.size();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            sb.append(tmp.get(i));
        }
        return sb.toString();
    }
}
