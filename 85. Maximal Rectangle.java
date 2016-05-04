/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/

//similar to 84. Largest Rectangle in Histogram 
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(matrix==null || m==0) { return 0; }
        int n = matrix[0].length;
        int max = 0;
        int[] height = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n==0) { return 0; }
        Stack<Integer> stack = new Stack();
        int max = 0;
        for(int i=0;i<=n;i++){
            int num = i==n ? -1 : heights[i];
            while(!stack.isEmpty() && num<heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = i - (stack.isEmpty()?-1:stack.peek()) - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}
