/**
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

        Write a function to determine if a number is strobogrammatic. The number is represented as a string.

        For example, the numbers "69", "88", and "818" are all strobogrammatic.

     */
    
    
    public static boolean Strobogrammatic(String str) {
        HashMap<Character,Character> hm = new HashMap<>();
        hm.put('0', '0'); hm.put('1', '1'); hm.put('8', '8');
        hm.put('6', '9'); hm.put('9', '6');
        int low = 0, high = str.length()-1;
        while(low<=high){
            if(hm.containsKey(str.charAt(low)) && hm.get(str.charAt(low))==str.charAt(high)){
                low++; high--; continue;
            }
            return false;
        }
        return true;
    }
