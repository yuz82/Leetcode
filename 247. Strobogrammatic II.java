 /**
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

        Find all strobogrammatic numbers that are of length = n.

        For example, Given n = 2, return ["11","69","88","96"].
     * @param n
     * @return 
     */
    
    public static List<String> Strobogrammatic(int n) {
        List<String> res = new ArrayList();
        builder(n, "", res);
        return res;
    }
    
    public static void builder(int n, String str, List<String> res){
        if(n==str.length()){
            res.add(str); return; 
        }
        char[] nums = {'0','1', '8', '6', '9'};
        boolean last = (n-str.length())==1;
        for(int i=0;i<nums.length;i++){
            //0 can't be first one except for n==1 && 6,9 can't be appended when there is one position left
            if((n!=1&&nums[i]=='0'&&str.length()==0) || (last&&(nums[i]=='6'||nums[i]=='9'))){
                continue;
            }
            StringBuilder tmp = new StringBuilder(str);
            append(last, tmp, nums[i]);
            builder(n, tmp.toString(), res);
        }
    }
    
    public static void append(boolean last, StringBuilder sb, char c){
        if(c=='6'){
            sb.insert(sb.length()/2, "69");
        }else if(c=='9'){
            sb.insert(sb.length()/2, "96");
        }else{
            sb.insert(sb.length()/2, (last? c : c+""+c));
        }
    }
