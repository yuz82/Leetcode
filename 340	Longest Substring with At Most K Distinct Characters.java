
//hashmap   
public static int lengthOfLongestSubstringKthDistinct(String str, int k){
        int n = str.length();
        if(str==null || n==0) { return 0; }
        int max = 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        int head = 0;
        for(int i=0;i<n;i++){
            char c = str.charAt(i);
            if(hm.containsKey(c)){
                int count = hm.get(c) + 1;
                hm.put(c, count);
            }else{
                while(hm.size()==k){
                    char peek = str.charAt(head++);
                    int count = hm.get(peek) - 1;
                    if(count==0) { hm.remove(peek); }
                    else{ hm.put(peek, count); }
                }
                hm.put(c, 1);
            }
            max = Math.max(max, i-head+1);
        }
        return max;
    }
