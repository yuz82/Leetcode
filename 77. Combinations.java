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
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int s, int n, int k){
        if(k==0) { 
            res.add(new ArrayList<Integer>(list)); return;
        }
        for(int i=s;i<=n;i++){
            list.add(i);
            helper(res, list, i+1, n, k-1);
            list.remove(list.size()-1);
        }
    }
}


//iterative
public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n==0 || k==0){ return res; }
		res.add(new ArrayList<Integer>());
		for(int i=1;i<=n;i++){
		    int size = res.size();
		    for(int j=0;j<size;j++){
		        if(res.get(j).size()<k){
		            List<Integer> list = new ArrayList<Integer>(res.get(j));
		            list.add(i);
		            res.add(list);
		        }
		    }
		}
		for(int i=0;i<res.size();i++){
		    if(res.get(i).size()!=k){
		        res.remove(i--);
		    }
		}
		return res;
}


//C(n,k)=C(n-1,k-1)+C(n-1,k)
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n - 1, k));
        return result;
    }
}

//dp and iterative
public List<List<Integer>> combine(int n, int k) {
    if(n < 1 || k < 1 || k > n)
        return Collections.emptyList();

    /** c(n, k) = c(n-1, k) + f(n, c(n-1, k-1)) **/
    @SuppressWarnings("unchecked")
    List<List<Integer>>[][] cache = new List[n + 1][k + 1];

    /** init cache of k == 0 **/
    for(int i = 0; i <= n; i++){
        cache[i][0] = new ArrayList<>();
        cache[i][0].add(new ArrayList<Integer>());
    }

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= i && j <= k; j++){
            /** combine(i, j) **/
            cache[i][j] = new ArrayList<>();
            if(i - 1 >= j)
                cache[i][j].addAll(cache[i - 1][j]);
            for(List<Integer> list: cache[i - 1][j - 1]){
                List<Integer> tmpList = new LinkedList<>(list);
                tmpList.add(i);
                cache[i][j].add(tmpList);
            }
        }
    }

    return cache[n][k];
}
