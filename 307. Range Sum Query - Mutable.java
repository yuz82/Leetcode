/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
*/

public class NumArray {
    class Node{
        int start, end, sum;
        Node left, right;
        Node(int s, int e){
            start = s; end = e;
        }
    }
    
    Node root;

    public NumArray(int[] nums) {
        int n = nums.length;
        root = buildTree(nums, 0, n-1);
    }
    
    public Node buildTree(int[] nums, int s, int e){
        if(s>e) { return null; }
        Node node = new Node(s, e);
        if(s==e){
            node.sum = nums[e]; 
        }else{
            int mid = s + (e-s)/2;
            node.left = buildTree(nums, s, mid);
            node.right = buildTree(nums, mid+1, e);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    void update(int i, int val) {
        update(root, i, val);
    }
    
    void update(Node root, int i, int val){
        if(root.start==i && root.end==i) {
            root.sum = val; return;
        }
        int mid = root.start + (root.end - root.start)/2;
        if(i<=mid) { update(root.left, i, val); }
        else { update(root.right, i, val); }
        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    public int sumRange(Node root, int i, int j){
        if(root.start==i && root.end==j){
            return root.sum;
        }
        int mid = root.start + (root.end - root.start)/2;
        if(j<=mid) { return sumRange(root.left, i, j); }
        else if(i>=mid+1){ return sumRange(root.right, i, j); }
        else{
            return sumRange(root.left, i, mid) + sumRange(root.right, mid+1, j);
        }    
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
