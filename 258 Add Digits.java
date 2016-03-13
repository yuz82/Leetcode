//Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
/*Could you do it without any loop/recursion in O(1) runtime?
result = 1+(n-1)%9
*/


public class Solution {
    public int addDigits(int num) {
        //parse int to String
        String str = String.valueOf(num);
        int len = str.length();
        if(len != 1){
            int sum = 0;
            for(int i=0;i<len;i++){
                sum += Character.getNumericValue(str.charAt(i));
            }
            num = addDigits(sum);
        }
        return num;
    }
}

// O(1)
public class Solution {
    public int addDigits(int num) {
      return 1 + (num - 1) % 9;
    }
}

