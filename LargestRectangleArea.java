/**
 * 84. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 *Input: [2,1,5,6,2,3]
 *Output: 10
 */

class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int prev = stack.pop();
                if (stack.isEmpty()) {
                    ans = Math.max(ans, heights[prev] * i);
                } else {
                    ans = Math.max(ans, heights[prev] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
