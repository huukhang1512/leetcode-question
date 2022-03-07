class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] > 0){
                stack.add(asteroids[i]);
            } else {
                int curA = asteroids[i];
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(curA) > stack.peek())
                    stack.pop();
                if(!stack.isEmpty() && Math.abs(curA) == stack.peek())
                    stack.pop();
                else if(stack.isEmpty() || stack.peek() < 0) 
                    // when the stack is empty, and the only remaining item is negative
                    stack.add(curA);
                
            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}