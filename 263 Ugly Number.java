/*
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
Note that 1 is typically treated as an ugly number.
*/

public class Solution {
    public boolean isUgly(int num) {
        if(num<1){
            return false;
        }
        if(num==1||num==2||num==3||num==5){
            return true;
        }
        if(num%2 != 0){
            if(num%3 != 0){
                if(num%5 != 0){
                    return false;
                }else{
                    return isUgly(num/5);
                }
            }else{
                return isUgly(num/3);
            }
        }else{
            return isUgly(num/2);
        }
    }
}

for (int i=2; i<6 && num>0; i++)
    while (num % i == 0)
        num /= i;
return num == 1;


public class Solution {
    public boolean isUgly(int num) {
        if(num<1){
            return false;
        }
        if(num == 1){
            return true;
        }
        while(num!=1){
            if(num%2==0){
                num /= 2;
                continue;
            }else if(num%3==0){
                num /= 3;
                continue;
            }else if(num%5==0){
                num /= 5;
                continue;
            }
            return false;
        }
        return true;
    }
}
