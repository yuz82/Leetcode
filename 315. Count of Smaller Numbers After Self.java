/*
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
*/

//note: not distinct number
/*
solution:  binary search
Traverse from the end of this array, for each element, using binary search to find the location(return value plus one then negate it) to insert in a new empty array, the position to insert is the number of smaller numbers after itself.
However, if using int[] to store the new array, although it has binarySearch() to simplify the code, the cost of insertion is hugh. Therefore, a binary search function implemented by arraylist is needed.
*/

//time limit exceed 
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if(n==0){ return res; }
        for(int i=0;i<n-1;i++){
            int count = 0;
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    count++;
                }
            }
            res.add(count);
        }
        res.add(0);
        return res;
    }
}
