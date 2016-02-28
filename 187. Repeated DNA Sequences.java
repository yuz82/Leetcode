/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/


public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList();
        int n = s.length();
        if(s==null || n==0) return list;
        HashSet<String> hs = new HashSet();
        HashSet<String> res = new HashSet();
        for(int i=0;i<=n-10;i++){
            String tmp = s.substring(i,i+10);
            if(!hs.contains(tmp)){
                hs.add(tmp);
            }else if(!res.contains(tmp)){
                res.add(tmp);
                list.add(tmp);
            }
        }
        return list;
    }
}
