/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
*/

public class Solution {
    HashMap<Integer, Integer> hm = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            hm.put(i, i);
        }
        for(int[] arr : edges){
            hm.put(getFather(arr[1]), getFather(arr[0]));
        }
        HashSet<Integer> hs = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            hs.add(getFather(entry.getValue()));
        }
        return hs.size();
    }
    
    public int getFather(int num){
        int father = hm.get(num);
        while(father!=hm.get(father)){
            father = hm.get(father);
        }
        return father;
    }
}
