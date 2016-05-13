/*
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

Example
For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
 
 //hashmap + queue   count in-degree
 //O(n+m)   n:node   m:edge
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        //find the node whose in-degree is 0
        HashMap<DirectedGraphNode, Integer> hm = new HashMap<>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(hm.containsKey(neighbor)){
                    hm.put(neighbor, hm.get(neighbor)+1);
                }else{
                    hm.put(neighbor, 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node : graph){
            if(!hm.containsKey(node)){
                queue.offer(node);
                res.add(node);
            }
        }
        while(!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for(DirectedGraphNode neighbor : node.neighbors){
                int count = hm.get(neighbor) - 1;
                if(count == 0){
                    queue.offer(neighbor);
                    res.add(neighbor);
                }
                hm.put(neighbor, count);
            }
        }
        return res;
    }
}
