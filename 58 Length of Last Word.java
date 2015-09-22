/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
return the length of last word in the string.
If the last word does not exist, return 0.
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s != null ){
            String[] split = s.split(" ");
            if(split.length > 0){
                String last = split[split.length-1];
                return last.length();
            }
        }
        return 0;
        
    }
}

public class Solution {
    public int lengthOfLastWord(String s) {
        String trim = s.trim();      //remove blank space in the beginning and the end
        int last = trim.lastIndexOf(" ");
        if (last < 0) {
            return trim.length();
        } else {
            return Math.abs(trim.length() - last -1);
        }
    }
}
