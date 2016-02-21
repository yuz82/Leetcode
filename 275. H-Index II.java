/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
*/

//binary search
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0, end = n-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(citations[mid]==n-mid){
                return citations[mid];
            }else if(citations[mid]>n-mid){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return n-(end+1);  
        //After iteration, it is guaranteed that right+1 is the one we need to find 
        //(i.e. n-(end+1) papars have at least n-(end+1) citations)
    }
}
