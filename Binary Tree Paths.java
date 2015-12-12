/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if(root==null){ return list; }
        String str = ""+root.val;
        if(root.left!=null){
            getPath(list, root.left, str);
        }
        if(root.right!=null){
            getPath(list, root.right, str);
        }
        if(root.left==null&&root.right==null){
            list.add(str);
        }
        return list;
    }
    
    public void getPath(List<String> list, TreeNode root, String str){
        str = str + "->" + root.val;
        if(root.left!=null){
            getPath(list, root.left, str);
        }
        if(root.right!=null){
            getPath(list, root.right, str);
        }
        if(root.left==null&&root.right==null){
            list.add(str);
        }
    }
}

//iteration
public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new LinkedList<>();

        if(root == null) return paths;

        if(root.left == null && root.right == null){
            paths.add(root.val+"");
            return paths;
        }

         for (String path : binaryTreePaths(root.left)) {
             paths.add(root.val + "->" + path);
         }

         for (String path : binaryTreePaths(root.right)) {
             paths.add(root.val + "->" + path);
         }

         return paths;

    }

