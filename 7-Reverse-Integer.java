/*
If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

public class Solution {
    public int reverse(int x) {
        boolean negative = false;
        int y = 0;
        if(x<0){ 
            negative = true;
            x *= -1;
        }
        while(x>0){
            int tmp = y;
            y = y*10 + x%10;
            if((y-x%10)/10 != tmp){
                return 0;
            }
            x /= 10;
        }
        if(negative == true){
            y *= -1;
        }
        
        return y;
    }
}
