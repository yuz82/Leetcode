/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

*/

//stack O(n)
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(height==null || n==0) { return 0; }
        int water = 0;
        Stack<Integer> stack = new Stack();
        int i = 0;
        while(i < n){
            if(stack.isEmpty() || height[i]<=height[stack.peek()]){
                stack.push(i++);
            }else{
                int pop = stack.pop();
                int tmp = stack.isEmpty() ? 0 : 
                (Math.min(height[stack.peek()], height[i]) - height[pop]) * (i-stack.peek()-1);
                water += tmp;
            }
        }
        return water;
    }
}

public int trap(int[] height) {
    int secHight = 0;
    int left = 0;
    int right = height.length - 1;
    int area = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            secHight = Math.max(height[left], secHight);
            area += secHight - height[left];
            left++;
        } else {
            secHight = Math.max(height[right], secHight);
            area += secHight - height[right];
            right--;
        }
    }
    return area;
}



public class Solution {
    public int trap(int[] A) {
        int i = 0, j = A.length - 1, result = 0, plank = 0;
        while(i <= j){
            plank = plank < Math.min(A[i], A[j]) ? Math.min(A[i], A[j]) : plank;
            result = A[i] >= A[j] ? result + (plank - A[j--]) : result + (plank - A[i++]);
        }
        return result;
    }
}
