
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Sentinel value

        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {

            // Current bar is smaller than the top of stack
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {

                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        // Process remaining bars
        while (stack.peek() != -1) {

            int height = heights[stack.pop()];
            int width = n - stack.peek() - 1;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}