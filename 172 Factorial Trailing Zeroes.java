/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

/*count how many 5 from 1 to n, 
because 0 comes from 2*5 and there are lots of 2 in n!*/

public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n!=0){
            count += n/5;
            n = n/5;
        }
        return count;
    }
}
