/* 
Write an algorithm to determine if a number is "happy".
A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number
12 + 92 = 82   平方
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

public class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        sum = getSum(n);
        hs.add(sum);
        while(sum != 1){//compute sum until it equals to one or repeats
            sum = getSum(sum);
            if(hs.contains(sum)){//if sum repeats
                return false;
            }
            hs.add(sum);
        }
        return true;
    }
    
    public int getSum(int n) {
        int sum = 0;
        while( n/10 > 0 ) {
            sum += Math.pow(n%10, 2);
            n = n/10;
        }
        sum += Math.pow(n, 2);
        return sum;
    }
}

//c solution
// for any unhappy number, they will fall into one specific loop "4->16->37->...->2->4"
int crazy(int num) {
    int sum = 0;
    while (num > 0) {
        int mod = num % 10;
        sum += mod * mod;
        num /= 10;
    }
    return sum;
}

bool isHappy(int n) {
    while (n != 1) {
        n = crazy(n);
        if (n == 4) {
            return false;
        }
    }
    return true;
}
