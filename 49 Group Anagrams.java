/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) { 
        //nlogn
        List<List<String>> anaGroups = new ArrayList<List<String>>();
        int len = strs.length;
        if(len == 0) return anaGroups;
        HashMap<String, List<String>> hm = new HashMap<String,List<String>>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);   //nlogn
            String sortStr = new String(ch);
            if(hm.containsKey(sortStr)){
                hm.get(sortStr).add(str);
            }else{
                List<String> al = new ArrayList<String>();
                al.add(str);
                hm.put(sortStr, al);
            }
        }
        for(Map.Entry<String, List<String>> list : hm.entrySet()){
            Collections.sort(list.getValue());
            anaGroups.add(list.getValue());
        }
        return anaGroups;
    }
}
