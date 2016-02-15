/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0) { return 0; }
        int count = 2;
        for(int i=2;i<n;i++){
            if(nums[i]>nums[count-2]){
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}

//HashMap
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(nums==null || n==0) { return 0; }
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], 1);
                nums[count] = nums[i];
                count++;
            }else{
                if(hm.get(nums[i])<2){
                    hm.put(nums[i], hm.get(nums[i])+1);
                    nums[count] = nums[i];
                    count++;
                }
            }
        }
        return count;
    }
}
