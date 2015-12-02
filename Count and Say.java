/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        if(n==1){ return "1"; }
        int i = 1;
        String str = new String();
        StringBuilder sb = new StringBuilder("1");
        int sum = 1;
        while(i<n){
            str = sb.toString();
            sb = new StringBuilder();
            int len = str.length();
            char cur = str.charAt(0);
            sum = 1;
            for(int j=1;j<len;j++){
                if(cur==str.charAt(j)){
                    ++sum;
                }else{
                    sb.append(sum).append(str.charAt(j-1));;
                    sum = 1;
                    cur = str.charAt(j);
                }
            }
            sb.append(sum).append(str.charAt(len-1));
            i++;
        }
        return sb.toString();
    }
}
