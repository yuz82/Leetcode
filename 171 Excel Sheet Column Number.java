/*
Given a column title as appear in an Excel sheet, return its corresponding column number.
For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

//ASCII 'A' -> 65
public class Solution {
    public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int sum = 0;
        for(int i=0;i<len;i++){
            sum = sum*26 + c[i]-64;
        }
        return sum;
    }
}


//recursive
public class Solution {
  public int titleToNumber(String s) {
    return s.length()==0?0:titleToNumber(s.substring(0,s.length()-1))*26+(s.charAt(s.length()-1)-'A'+1);
}
