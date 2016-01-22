/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/

//loop
public class Solution {
    public boolean isPowerOfThree(int n) {
        double num = (double) n;
        while(Math.abs(num)>2){
            num = num / 3;
        }
        if(num == 1){
            return true;
        }
        return false;
    }
}

//loop2
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        while(n%3==0){
            n /= 3;
        }
        if(n!=1){
            return false;
        }
        return true;
    }
}

//recursive
public boolean isPowerOfThree(int n) {
    return n>0 && (n==1 || (n%3==0 && isPowerOfThree(n/3)));
}


//The idea is to convert the original number into radix-3 format and check if it is of format 10* where 0* means k zeros with k>=0.
public boolean isPowerOfThree(int n) {
    return Integer.toString(n, 3).matches("10*");
}


public boolean isPowerOfThree(int n) {
    return (Math.log10(n) / Math.log10(3)) % 1 == 0;
}

