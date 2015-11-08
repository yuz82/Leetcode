/*
Given an array of integers, every element appears twice except for one. Find that single one.
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
//HashSet
public class Solution {
    public int singleNumber(int[] nums) {
        HashSet ht = new HashSet();
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(ht.contains(nums[i])){
                ht.remove(nums[i]);
            }else{
                ht.add(nums[i]);
            }
        }
        int x = -1;
        for (Object value : ht) {
            x = (int)value;
	      }
	      /*
	      Iterator it = map.iterator();
        int re =(int)it.next();
        */
	      return x;
    }
}

//XOR
public class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        int len = nums.length;
        for(int i=1;i<len;i++){
            result ^= nums[i];
        }
        return result;
    }
}



