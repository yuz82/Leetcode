/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

**:only to the one below and it's next
*/

//from bottom to top
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}


//from top to bottom use two arrays
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null) { return 0; }
        int n = triangle.size();
        int[] pre = new int[n];
        int[] res = new int[n];
        Arrays.fill(pre, Integer.MAX_VALUE);
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            pre = Arrays.copyOf(res,n);
            for(int j=0;j<=i;j++){
                int left = j>0?pre[j-1]:Integer.MAX_VALUE;
                res[j] = Math.min(left, pre[j]) + triangle.get(i).get(j); 
            }
        }
        Arrays.sort(res); 
        return res[0];
    }
}
