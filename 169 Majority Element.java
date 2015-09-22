/*
Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    public int majorityElement(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0;i<size;i++){
            int tmp = 0;
            if(hm.containsKey(nums[i])){
                tmp = hm.get(nums[i]) + 1;
                hm.put(nums[i],tmp);
            }else {
                hm.put(nums[i],1);
                tmp = 1;
            }
            if(tmp > (size/2)){
                return nums[i];
            }
        }
        return Integer.MAX_VALUE;
    }
}

/*
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; 
        int count = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i]; 
                count++;
            } else {
                if (nums[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate; 
    }
}

public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
}
*/
