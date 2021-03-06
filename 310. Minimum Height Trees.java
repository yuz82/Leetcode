/*
For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Hint:

How many MHTs can a graph have at most?
Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/
//HashMap<Integer, List<Integer>>
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int len = edges.length;
        if(n==0) { return new ArrayList<Integer>(); }     //only n==0
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++) { hm.put(i, new ArrayList<Integer>()); }   //单独initial，保证每个点都有
        for(int i=0;i<len;i++){
            hm.get(edges[i][0]).add(edges[i][1]);
            hm.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for(Map.Entry<Integer, List<Integer>> e : hm.entrySet()){
            if(e.getValue().size()<=1){ leaves.add(e.getKey()); }  //<=  保证edges为空时，node能加进去
        }
        while(n>2){   //而不是leaves.size()>2 
            n = n - leaves.size();  
            List<Integer> newLeaves = new ArrayList<>();
            for(int i=0;i<leaves.size();i++){
                List<Integer> list = hm.get(leaves.get(i));
                Integer node = list.get(0);
                hm.get(node).remove(leaves.get(i));
                if(hm.get(node).size()==1) { newLeaves.add(node); }  //==  而不是<=，保证node只被加一次
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}

//List<Set<Integer>>
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int m = edges.length; 
        List<Integer> leaves = new ArrayList();
        if(m==0) { leaves.add(0); return leaves; }
        List<Set<Integer>> mapping = new ArrayList();
        for(int i=0;i<n;i++) { mapping.add(new HashSet<Integer>()); }
        for(int i=0;i<m;i++){
            mapping.get(edges[i][0]).add(edges[i][1]);
            mapping.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<n;i++){
            if(mapping.get(i).size()==1) {
                leaves.add(i);
            }
        }
        while(n>2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList();
            for(int i=0;i<leaves.size();i++){
                int node = mapping.get(leaves.get(i)).iterator().next();
                mapping.get(node).remove(leaves.get(i));
                if(mapping.get(node).size()==1){
                    newLeaves.add(node);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
