/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C-A)*(D-B)+(G-E)*(H-F);
        int left = Math.max(A,E);
        int right = Math.max(Math.min(C,G), left);
        int top = Math.min(D,H);
        int bottom = Math.min(Math.max(B,F), top);
        return area - (right-left)*(top-bottom);
    }
}
