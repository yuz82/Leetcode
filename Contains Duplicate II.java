/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j 
in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
                if(i-hm.get(nums[i])<=k){
                    return true;
                }else{
                    hm.put(nums[i],i);
                }
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                hm.put(nums[i],i);
            }
        }
        return false;
    }
}
