/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:
string encode(vector<string> strs) {   // ... your code   return encoded_string; } 
Machine 2 (receiver) has the function: 
vector<string> decode(string s) {   //... your code   return strs; }

So Machine 1 does:
string encoded_string = encode(strs); 
and Machine 2 does:
vector<string> strs2 = decode(encoded_string); 
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note: The string may contain any possible characters out of 256 valid ascii characters. 
Your algorithm should be generalized enough to work on any possible characters. 
Do not use class member/global/static variables to store states. 
Your encode and decode algorithms should be stateless. 
Do not rely on any library method such as eval or serialize methods. 
You should implement your own encode/decode algorithm.
*/

/**
 *
 记录长度法
复杂度
时间 O(N) 空间 O(1)

思路
本题难点在于如何在合并后的字符串中，区分出原来的每一个子串。这里我采取的编码方式，是将每个子串的长度先赋在前面，然后用一个#隔开长度和子串本身。这样我们先读出长度，就知道该读取多少个字符作为子串了。

注意
为了简化代码，这里使用了indexOf和substring这两个属于String的API，实际上复杂度和遍历是一样的。
 */
 
 public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();
        for(String str : strs){
            // 对于每个子串，先把其长度放在前面，用#隔开
            output.append(String.valueOf(str.length())+"#");
            // 再把子串本身放在后面
            output.append(str);
        }
        return output.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new LinkedList<String>();
        int start = 0;
        while(start < s.length()){
            // 找到从start开始的第一个#，这个#前面是长度
            int idx = s.indexOf('#', start);
            int size = Integer.parseInt(s.substring(start, idx));
            // 根据这个长度截取子串
            res.add(s.substring(idx + 1, idx + size + 1));
            // 更新start为子串后面一个位置
            start = idx + size + 1;
        }
        return res;
    }
}
