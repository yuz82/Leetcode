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

//O(n)
public String getPermutation(int n, int k) {
    List<Integer> num = new LinkedList<Integer>();
    for (int i = 1; i <= n; i++) num.add(i);
    int[] fact = new int[n];  // factorial
    fact[0] = 1;
    for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];  //store n!
    k = k-1;
    StringBuilder sb = new StringBuilder();
    for (int i = n; i > 0; i--){
        int ind = k/fact[i-1];
        k = k%fact[i-1];
        sb.append(num.get(ind));
        num.remove(ind);
    }
    return sb.toString();
}

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        --k;
        StringBuilder sb = new StringBuilder();
        while(list.size()>0){
            int help = helper(--n);
            int cur = (k) / help;
            sb.append(list.remove(cur));
            k = (k) % help;
        }
        return sb.toString();
    }
    
    public int helper(int n){
        int res = 1;
        for(int i=n;i>0;i--){
            res *= i;
        }
        return res;
    }
}
