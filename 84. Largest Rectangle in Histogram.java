/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/

//stack   O(n)：因为每个数进出这个stack的次数为1   递增栈
public class Solution {
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
