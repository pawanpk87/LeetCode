class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int asteroid : asteroids) {
            if(asteroid > 0) {
                st.push(asteroid);
                continue;
            }
            
            while(!st.isEmpty() && 
                  isCollid(st.peek(), asteroid) && 
                  st.peek() < Math.abs(asteroid)) {
                st.pop();
            }
            
            if(!st.isEmpty() && st.peek() == Math.abs(asteroid)) {
                st.pop();
                continue;
            }
            
            if(st.isEmpty() || st.peek() < 0) {
                st.push(asteroid);
            }
        }
        
        int[] res = new int[st.size()];
        int index = st.size() - 1;
        while(!st.isEmpty()) {
            res[index] = st.pop();
            index--;
        }
        
        return res;
    }
    
    private boolean isCollid(int leftAsteroid, int rightAsteroid) {
        return leftAsteroid > 0 && rightAsteroid < 0;
    }
}