/*
the numbers should equal to the difference of existed numbers in the array and the numbers in the array should keep distinct
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
