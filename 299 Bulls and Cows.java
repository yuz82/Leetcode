/*
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
*/

public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int len = secret.length();
        char[] s = new char[10];
        char[] g = new char[10];
        for(int i=0;i<len;i++){
            int tmps = secret.charAt(i) - '0';
            s[tmps]++;
            int tmpg = guess.charAt(i) - '0';
            g[tmpg]++;
            if(tmps == tmpg){
                bull++;
            }
        }
        for(int i=0;i<10;i++){
            cow += s[i]>g[i]?g[i]:s[i];
        }
        cow -= bull;
        return bull+"A"+cow+"B";
    }
}


//solution 2  one-pass
public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        if (secret.charAt(i) == guess.charAt(i)) bulls++;
        else {
            if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
            if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
        }
    }
    return bulls + "A" + cows + "B";
}
