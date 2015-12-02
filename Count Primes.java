/*
Count the number of prime numbers less than a non-negative number, n.
More Hints in leetcode
*/

//time limit exceeded version
public class Solution {
    public int countPrimes(int n) {
        if(n<3){ return n;}
        int count = 2;
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(2);
        for(int i=3;i<n;i++){
            boolean flag = true;
            Iterator<Integer> it = hs.iterator();
            while(it.hasNext()){
                if(i%it.next()==0){
                    flag = false;
                    break;
                }
            }
            if(flag==true){
                hs.add(i);
                count++;
            }
        }
        return count;
    }
}

