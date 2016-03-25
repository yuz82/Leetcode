/*
Given an array of integers, find out whether there are two distinct indices i and j in the array 
such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
*/

//TreeSet  O(nlogN)
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if(n<1 || k<=0) { return false; }
        TreeSet<Integer> ts = new TreeSet();
        for(int i=0;i<n;i++){
            //the least element in this set greater than or equal to the given element
            Integer ceiling = ts.ceiling(nums[i]-t);
            if(ceiling!=null && ceiling<=nums[i]) { return true; }
            //the greatest element in this set less than or equal to the given element
            Integer floor = ts.floor(nums[i]+t);
            if(floor!=null && floor>=nums[i]) { return true; }
            ts.add(nums[i]);
            if(i>=k) { ts.remove(nums[i-k]); }
        }
        return false;
    }
}
