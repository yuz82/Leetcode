/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

//hashset
public class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            if(hs.contains(nums[i])){
                hs.remove(nums[i]);
            }else{
                hs.add(nums[i]);
            }
        }
        int[] result = new int[2];
        Iterator it = hs.iterator();
        int i = 0;
        while (it.hasNext()) {
            result[i] = (int)it.next();
            i++;
        }
        return result;
    }
}

//bit manipulation
public class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int diff = 0; //get the XOR of two distinct number
        for(int i=0;i<n;i++){
            diff ^= nums[i];
        }
        diff &= -diff; // get the last set bit
        int[] result = new int[2];
        for(int i=0;i<n;i++){
            if((nums[i]&diff) == 0){
                result[0] ^= nums[i];
            }else{
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}
