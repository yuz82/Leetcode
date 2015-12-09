/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

*/

//A  65
public class Solution {
    
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.insert(0,(char)((--n)%26+'A'));
            n = n/26;
        }
        return sb.toString();
    }
}

//recursive
public class Solution {
    public String convertToTitle(int n) {
        return n==0 ? "" : convertToTitle(--n/26)+(char)(n%26+'A');
    }
}
