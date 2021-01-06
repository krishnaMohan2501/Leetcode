class TrappingWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;
        for (int right = 0; right < height.length; right++) {
            while (!stack.isEmpty() 
                   &&  height[right]>height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                // Identified water trapped = width * height
                int water = (right - left - 1) * 
                    (Math.min(height[right], height[left]) - height[bottom]);
                totalWater += water;
            }
            stack.push(right);
        }
        return totalWater;
    }
}
