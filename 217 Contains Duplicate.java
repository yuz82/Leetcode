/*
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.
*/

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> distinct = new HashMap<Integer,Integer>();
        if(nums.length == 0){
            return false;
        }else{
            distinct.put(nums[0],1);
            for(int i=1; i< nums.length; i++){
                if(distinct.containsKey(nums[i])){
                    return true;
                }else {
                    distinct.put(nums[i],1);
                }
            }
            return false;
        }
    }
}

/*
//less than O(n)
public class Solution {
    public boolean containsDuplicate(int[] nums) {
     boolean flag=true;
     Set<Integer> numList=new HashSet<Integer>();
     for(int i=0;i<nums.length&&flag;i++){
        flag = numList.add(nums[i]);
     }
     return !flag;
    }
}

//neat sorting solution
public static boolean sortingSolution(int [] A) {
    if (A == null || A.length == 0) return false;
    Arrays.sort(A);
    int last = A[0];
    for (int i = 1; i < A.length; i ++) {
        if (A[i] == last) return true;
        last = A[i];
    }
    return false;
}
*/
