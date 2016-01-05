/*
the numbers should equal to the difference of existed numbers in the array and the numbers in the array should keep distinct

hint: find the maximum common factor
*/

public static void numgame(int a, int b) {
        HashSet<Integer> map = new HashSet<>();
        map.add(a);
        map.add(b);
        boolean endmark = true;
        while (endmark) {
            endmark = false;
            for (int num1 : map) {
                for (int num2 : map) {
                    int next = Math.abs(num1 - num2);
                    if (!map.contains(next) && next > 0) {
                        System.out.print(next+" ");
                        map.add(next);
                        endmark = true;
                        break;
                    }
                }
                if(endmark) break;
            }
        }
    }

    public static void main(String[] args) {
        numgame(20, 2);
        //18 16 14 4 12 10 6 8
    }
    
    
    //find max common factor
     public static void numGame2(int num1, int num2){
       int mcd = gcd(num1, num2);
       int max = num1>num2?num1:num2;
       while(true){
            max = max - mcd;
            if(max>0){
               System.out.print(max+" ");
               
           }else{
                break;
            }
       }
   }
   
    public static int gcd(int num1, int num2) {
        return num2==0 ? num1 : gcd(num2, num1%num2);
    }

    public static void main(String[] args) {
        numGame2(20, 2);
    }
