/*
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/

public class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        
        char[] c = s.toCharArray();
        int len = c.length;
        int sum = hm.get(c[len-1]);
        for(int i=len-2;i>-1;i--) {
            if(hm.get(c[i]) < hm.get(c[i+1])) {
                sum -= hm.get(c[i]);
            }else {
                sum += hm.get(c[i]);
            }
        }
        return sum;
    }
}

