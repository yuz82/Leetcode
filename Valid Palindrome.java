/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        int end = s.length()-1;
        int start = 0;
        while(start < end){
            while(start<end&&!Character.isLetterOrDigit(sb.charAt(start))){
                start++;
            }
            while(start<end&&!Character.isLetterOrDigit(sb.charAt(end))){
                end--;
            }
            if(start<end){
                if(sb.charAt(start++)!=sb.charAt(end--)){
                    return false;
                }
            }
        }
        return true;
    }
}
