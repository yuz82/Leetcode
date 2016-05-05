/*
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
*/

//int[]  O(n+m) space    O(mn) time
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        if(primes==null || m==0) { return 0; }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] nums = new int[m];
        int[] index = new int[m];
        nums = Arrays.copyOf(primes, m);
        for(int i=1;i<n;i++){
            int min = getMin(nums);
            ugly[i] = min;
            for(int j=0;j<m;j++){
                if(nums[j]==min){
                    nums[j] = primes[j] * ugly[++index[j]];
                }
            }
        }
        return ugly[n-1];
    }
    
    public int getMin(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        if(primes==null || m==0) { return 0; }
        int[] index = new int[m];
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1;i<n;i++){
            res[i] = Integer.MAX_VALUE;
            for(int j=0;j<m;j++){
                res[i] = Math.min(res[i], primes[j]*res[index[j]]);
            }
            for(int j=0;j<m;j++){
                if(res[i] == primes[j]*res[index[j]]){
                    ++index[j];
                }
            }
        }
        return res[n-1];
    }
    
}



//heap   O(nlogm) time
public class Solution {
    public class Node{
        int index, num, prime;
        public Node(int index, int num, int prime){
            this.index = index; this.num = num; this.prime = prime; 
        }
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        if(primes==null || m==0) { return 0; }
        PriorityQueue<Node> heap = new PriorityQueue(new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n1.num - n2.num;
            }
        });
        int[] res = new int[n];
        res[0] = 1;
        for(int i=0;i<m;i++){ heap.offer(new Node(0,primes[i], primes[i])); }
        for(int i=1;i<n;i++){
            Node min = heap.peek();
            res[i] = min.num;
            while(heap.peek().num==min.num){
                Node tmp = heap.poll();
                heap.offer(new Node(tmp.index+1, tmp.prime * res[++tmp.index], tmp.prime));
            }
        }
        return res[n-1];
    }
    
}
