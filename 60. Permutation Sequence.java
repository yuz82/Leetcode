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
        ArrayList<String> res = new ArrayList<>();
        int help = helper(n-1);
        int first = (k-1) / help + 1;
        int left = (k-1) % helper(n-1);
        res.add("");
        for(int i=1;i<=n;i++){
            if(i==first) { continue; }
            int size = res.size();
            for(int j=0;j<size;j++){
                String str = res.get(0);
                int len = str.length();
                res.remove(0);
                for(int t=len;t>=0;t--){
                    StringBuilder sb = new StringBuilder(str);
                    sb.insert(t,i);
                    res.add(sb.toString());
                }
            }
        }
        return first+res.get(left);
    }
    
    public int helper(int n){
        int res = 1;
        for(int i=n;i>0;i--){
            res *= i;
        }
        return res;
    }
}
