/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/

/*
The idea is to use a mask to find the leftmost common digits of m and n. 
Example: m=1110001, n=1110111, and you just need to find 1110000 and it will be the answer.
*/
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while((m&mask)!=(n&mask)){
            mask = mask<<1;   
        }
        return m&mask;
    }
}
