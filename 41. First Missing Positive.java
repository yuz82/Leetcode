/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
Note: it could contain duplicates, and is not consective.   e.g. //1,1->2  1001,-1->1 
*/

//O(n) time, O(1) space
//key: move every value to the position of its value
public class Solution {
    //1,1->2  1001,-1->1 
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0) { return 1; }
        for(int i=0;i<n;i++){
            int target = nums[i];
            while(target<=n && target>0 && target != nums[target-1]){
                int tmp = nums[target-1];
                nums[target-1] = target;
                target = tmp;
            }
        }
        for(int i=1;i<=n;i++){
            if(nums[i-1]!=i){ return i; }
        }
        return n+1;
    }
}


//O(n) time, O(n) space
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0) { return 1; }
        int count = 1;
        HashSet<Integer> hs = new HashSet();
        for(int i=0;i<n;i++){
            if(nums[i]>0) { 
                count++; 
                hs.add(nums[i]);
            }
        }
        for(int i=1;i<=count;i++){
            if(!hs.contains(i)) { return i; }
        }
        return 1;
    }
}
