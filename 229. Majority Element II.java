/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
*/

//to be continued...

//two pointers && sort
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int start = 0, end = 0;
        List<Integer> res = new ArrayList();
        while(end<n){
            while(end<n && nums[end]==nums[start]){ end++; }
            if((end-start)>n/3) { res.add(nums[start]); }
            start = end;
        }
        return res;
    }
}

 //Boyer-Moore method
public class Solution{
    public List<Integer> majorityElement(int[] nums){
        List<Integer> rst = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return rst;
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
        for(int num : nums){
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
            else if(count1 == 0){
                candidate1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int num : nums){
            if(num == candidate1) count1+=2;
            else count1--;
            if(num == candidate2) count2 += 2;
            else count2--;
        }
        if(count1 > 0) rst.add(candidate1);
        if(count2 > 0) rst.add(candidate2);
        return rst;
    }
}
