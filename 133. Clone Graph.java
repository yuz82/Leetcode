/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
//hashmap + list(queue)
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) { return null; }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
        List<UndirectedGraphNode> nodes = new ArrayList<>();
        //clone nodes
        nodes.add(node);
        hm.put(node, new UndirectedGraphNode(node.label));
        int index = 0;
        while(index < nodes.size()){
            List<UndirectedGraphNode> neighbors = nodes.get(index++).neighbors;
            for(int i=0;i<neighbors.size();i++){
                if(!hm.containsKey(neighbors.get(i))){
                    nodes.add(neighbors.get(i));
                    hm.put(neighbors.get(i), new UndirectedGraphNode(neighbors.get(i).label));
                }
            }
        }
        //clone neighbors
        for(int i=0;i<nodes.size();i++){
            for(int j=0;j<nodes.get(i).neighbors.size();j++){
                hm.get(nodes.get(i)).neighbors.add(hm.get(nodes.get(i).neighbors.get(j)));
            }
        }
        return hm.get(node);
    }
}
