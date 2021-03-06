/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.
*/

//extra space: O(n)
//the possible value of h is no more than n
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>n){
                count[n]++;
            }else{
                count[citations[i]]++;
            }
        }
        int total = 0;
        for(int i=n;i>-1;i--){
            total += count[i];
            if(total>=i){
                return i;
            }
        }
        return 0;
    }
}

//sort
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for(int i=n;i>0;i--){
            if(citations[n-i]>=i){
                return i;
            }
        }
        return 0;
    }
}
