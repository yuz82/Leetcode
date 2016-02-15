/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

*/

//O(n)
public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while(left < right){
            int tmp = Math.min(height[left], height[right]) * (right-left);
            max = Math.max(max, tmp);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}

//time limited exceed  O(n^2)
public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if(height==null || n==0){ return 0; }
        int max = 0;
        for(int i=0;i<n-1;i++){
            int min = height[i];
            for(int j=i+1;j<n;j++){
                min = Math.min(min, height[j]);
                max = Math.max(max, min * (j-i));
            }
        }
        return max;
    }
}
