public static int secondMax(int[] a) {
        //O(n)
        TreeSet<Integer> tree = new TreeSet<>();
        int length = a.length;
        if(length == 1) return a[0];
        for(int i = 0; i < length; i++){
            tree.add(a[i]);
            if(tree.size() > 2){
                tree.pollFirst();
            }
        }
        return tree.pollFirst();
    }

    public static void main(String[] args) {
        int[] input = {3, 3, 2, 1, 4};
        System.out.println(secondMax(input));
    }
