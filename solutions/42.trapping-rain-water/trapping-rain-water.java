class Solution {
    public int trap(int[] height) {
        int res=0;
        Stack<Integer> stack=new Stack();
        int current=0;
        while(current<height.length){
            while(!stack.empty() && height[current]>height[stack.peek()]){
                int top = stack.pop();
                if(stack.empty()){
                    break;
                }
                int distance = current - stack.peek() -1;
                int bounded=Math.min(height[current],height[stack.peek()])-height[top];
                res+=distance*bounded;
            }
            stack.push(current++);
        }
        return res;
    }
}