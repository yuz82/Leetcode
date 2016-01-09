/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/

public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        List<Set<Character>> list = new ArrayList();
        for(int i=0;i<n;i++){
            Set<Character> hs = new HashSet<Character>();
            String tmp = words[i];
            int len = tmp.length();
            for(int j=0;j<len;j++){
                hs.add(tmp.charAt(j));
            }
            list.add(hs);
        }
        int max = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(i,j,list)){
                    int tmp = words[i].length()*words[j].length();
                    max = max>tmp ? max : tmp;
                }
            }
        }
        return max;
    }
    
    public boolean check(int i,int j, List<Set<Character>> list){
        Iterator it = list.get(i).iterator();
        while(it.hasNext()){
            if(list.get(j).contains(it.next())){
                return false;
            }
        }
        return true;
    }
}
