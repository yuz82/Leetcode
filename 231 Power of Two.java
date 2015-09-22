/*
Given an integer, write a function to determine if it is a power of two.
*/

public class Solution {
    public boolean isPowerOfTwo(int x) {
        double n = (double)x;
        while(Math.abs(n) > 1) {
            n = n / 2;
        }
        if ( n==1 ) {
            return true;
        }
        return false;
    }
    
}


//bit manipulation
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0; 
    }
}
