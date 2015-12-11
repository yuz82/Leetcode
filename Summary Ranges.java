/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/
//solution 1
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        int n = nums.length;
        if(nums==null||n<1){
            return list;
        }
        int pre = 0;
        if(n==1){
            list.add(nums[pre]+"");
            return list;
        }
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]+1){
                addToList(list,nums,pre,i-1);
                pre = i;
            }
            if(i==n-1){
                addToList(list,nums,pre,i);
            }
        }
        return list;
    }
    
    public void addToList(List<String> list, int[] nums, int i, int j){
        if(nums[i] == nums[j]){
            list.add(nums[i]+"");
        }else {
            list.add(nums[i]+"->"+nums[j]);
        }
    }
   
}

//solution 2
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        int n = nums.length;
        if(nums==null||n<1){
            return list;
        }
        int pre = 0;
        if(n==1){
            list.add(nums[pre]+"");
            return list;
        }
        for(int i=1;i<n;i++){
            while(i<n&&nums[i]==nums[i-1]+1){
                i++;
            }
            addToList(list,nums,pre,i-1);
            pre = i;
            if(i==n-1){
                addToList(list,nums,pre,i);
            }
        }
        return list;
    }
    
    public void addToList(List<String> list, int[] nums, int i, int j){
        if(nums[i] == nums[j]){
            list.add(nums[i]+"");
        }else {
            list.add(nums[i]+"->"+nums[j]);
        }
    }
   
}

//solution 3
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList();
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }else{
                list.add(a+"");
            }
        }
        return list;
    }
    
}
