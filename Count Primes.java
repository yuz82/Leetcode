/*
Count the number of prime numbers less than a non-negative number, n.
More Hints in leetcode
*/

//time limit exceeded version 1 
//divide all primes before
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


//time limite exceeded version 2
//O(n^1.5)  sqrt
public class Solution {
    public int countPrimes(int n) {
        if(n<3) { return n;}
        int count = 2;
        for(int i=3;i<n;i++){
            for(int j=2;j*j<i;j++){
                if(i%j==0){
                    continue;
                }
            }
            count++;
        }
        return count;
    }
}

//accepted   using bitset
public class Solution {
    public int countPrimes(int n) {
        BitSet isNotPrime = new BitSet(n); //initialize with false
        isNotPrime.set(0);
        isNotPrime.set(1);
        int count = 0;
        int i = 0;
        while(i < n){
            i = isNotPrime.nextClearBit(++i);
            if(i>=n){
                return count;
            }
            count++;
            for(int j=2;j*i<n;j++){
                isNotPrime.set(j*i);
            }
        }
        return count;
    }
}
