/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

*/

//bfs  
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int len = wordList.size();
        if(wordList==null || len==0) { return 0; }
        HashSet<String> hs = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        queue.add(beginWord);
        hs.add(beginWord);
        while(!queue.isEmpty()){
            ++level;
            int size = queue.size();
            for(int i=0;i<size;i++){
                for(String word : getNextWords(queue.poll(), wordList)){
                    if(hs.contains(word)) { continue; }
                    if(word.equals(endWord)) { return level; }
                    hs.add(word); 
                    queue.offer(word);
                }
            }
        }
        return 0;
    }
    
    
    public List<String> getNextWords(String word, Set<String> wordList){
        List<String> words = new ArrayList<>();
        int n = word.length();
        for(int i=0;i<n;i++){
            for(char c='a';c<='z';c++){
                if(word.charAt(i)==c) { continue; }
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, c);
                String str = sb.toString();
                if(wordList.contains(str)) { words.add(str); }
            }
        }
        return words;
    }
}
