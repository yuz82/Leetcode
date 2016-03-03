/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/

//can't use double to mutiple and plus because of overflow
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];
        for(int i=m-1;i>-1;i--){
            for(int j=n-1;j>-1;j--){
                int low = i+j+1, high = i+j;
                int sum = (num1.charAt(i)-'0') * (num2.charAt(j)-'0') + res[low];
                res[low] = sum % 10;
                res[high] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<m+n && res[i]==0){ ++i; }
        for(;i<m+n;i++){
            sb.append(res[i]);
        }
        return sb.length()==0?"0":sb.toString();
    }
}
