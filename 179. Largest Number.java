/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

public class Solution {
    public String largestNumber(int[] nums) {
        int n =nums.length;
        String[] strs = new String[n];
        for(int i=0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2){
                String str1 = s1+s2;
                String str2 = s2+s1;
                return str2.compareTo(str1);
            }
        });
        if(strs[0].equals("0")) { return "0"; }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
