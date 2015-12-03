/*
count the number of distinct substring 
*/

public class DistinctSubstring {
    //O(n^2)

    public static int numSubstrings(String text) {
        int length = text.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                set.add(text.substring(i, j));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.print(numSubstrings("aaaaa"));
    }
}
