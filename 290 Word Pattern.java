/*
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
Example:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        int p_len = pattern.length();
        String[] array = str.split(" ");
        int len = array.length;
        if(p_len != len){
            return false;
        }
        Map<Character,String> hm = new HashMap<Character,String>();
        for(int i=0;i<len;i++){
            if(hm.containsKey(pattern.charAt(i))){
                if(!hm.get(pattern.charAt(i)).equals(array[i])){
                    return false;
                }
            }else{
                if(hm.containsValue(array[i])){
                    return false;
                }
                hm.put(pattern.charAt(i),array[i]);
            }
        }
        return true;
    }
}

