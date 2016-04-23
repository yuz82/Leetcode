/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]

*/

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList();
        int n = input.length();
        for(int i=0;i<n;i++){
            char c = input.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                String sub1 = input.substring(0, i);
                String sub2 = input.substring(i+1);
                List<Integer> res1 = diffWaysToCompute(sub1);
                List<Integer> res2 = diffWaysToCompute(sub2);
                for(Integer r1 : res1){
                    for(Integer r2 : res2){
                        int sum = 0;
                        switch(c){
                            case '+': sum = r1 + r2; break;
                            case '-': sum = r1 - r2; break;
                            case '*': sum = r1 * r2; break;
                        }
                        res.add(sum);
                    }
                }
            }
        }
        if(res.size()==0) { res.add(Integer.parseInt(input)); }
        return res;
    }
}

