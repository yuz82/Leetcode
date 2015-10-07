/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //recursive
public class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = 0;
        if(root != null){
            level_Order(root, level);
        }
        return list;
    }
    public void level_Order(TreeNode root, int level){
        if(root!=null){
            int size = list.size();
            List<Integer> levelList = new ArrayList<Integer>();
            if(level < size){
                levelList = list.get(level);
                levelList.add(root.val);
            }else{
                levelList.add(root.val);
                list.add(levelList);
            }
            
            
            level_Order(root.left, level+1);
            level_Order(root.right, level+1);
        }
        
    }
}

//BFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for(int i=0;i<len;i++){
                if(queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            list.add(subList);
        }
        return list;
    }
}
