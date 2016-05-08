
//hashmap && queue  
public static int lengthOfLongestSubstringKthDistinct(String str, int k){
        int n = str.length();
        if(str==null || n==0) { return 0; }
        HashMap<Character, Integer> hm = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        int max = 0;
        for(int i=0;i<n;i++){
            char c = str.charAt(i);
            queue.offer(c);
            if(hm.containsKey(c)){
                int count = hm.get(c) + 1;
                hm.put(c, count);
            }else{
                while(hm.size()==k){
                    char peek = queue.poll();
                    int count = hm.get(peek) - 1;
                    if(count==0) { hm.remove(peek); }
                    else{ hm.put(peek, count); }
                }
                hm.put(c, 1);
            }
            max = Math.max(max, queue.size());
        }
        return max;
    }
