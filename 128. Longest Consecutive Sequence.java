/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/


//O(n)
public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        int max = 0;
        for(int n : nums){
            if(hm.containsKey(n)) { continue; }
            int left = hm.containsKey(n-1) ? hm.get(n-1) : 0;
            int right = hm.containsKey(n+1) ? hm.get(n+1) : 0;
            int sum = left+right+1;
            max = Math.max(max, sum);
            hm.put(n, sum);
            hm.put(n-left, sum);
            hm.put(n+right, sum);
        }
        return max;
    }
}
