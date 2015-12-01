/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i>-1||j>-1||carry!=0){
            int sum = carry;
            if(i>-1){
                sum += Character.getNumericValue(a.charAt(i)); 
                --i;
            }
            if(j>-1){
                sum += Character.getNumericValue(b.charAt(j));
                --j;
            }
            carry = sum / 2;
            sb.append(sum % 2);
        }
        return sb.reverse().toString();
    }
}
