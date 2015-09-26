/*
Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;

            for(int i=len-1;i>-1;i--){
                if(digits[i]==9){
                    digits[i]=0;
                    if(i==0){
                        return move(len+1);
                    }
                }else{
                    digits[i] +=1;
                    break;
                }
            }

        return digits;
    }
    public int[] move(int len){
        int[] arr = new int[len];
        arr[0] = 1;
        return arr;
    }
}


public int[] plusOne(int[] digits) {

    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }

        digits[i] = 0;
    }

    int[] newNumber = new int [n+1];
    newNumber[0] = 1;

    return newNumber;
}
