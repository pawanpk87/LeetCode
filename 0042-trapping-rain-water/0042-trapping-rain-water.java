class Solution {
    private int[] getPrevGreaterElement(int[] height){
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int[] nextPrevGreaterElements = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && st.peek() <= height[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nextPrevGreaterElements[i] = -1;
                st.push(height[i]);
            } else{
                nextPrevGreaterElements[i] = st.peek();
            }
        }
        return nextPrevGreaterElements;
    }
    
    private int[] getNextGreaterElement(int[] height){
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int[] nextGreaterElements = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= height[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nextGreaterElements[i] = -1;
                st.push(height[i]);
            } else{
                nextGreaterElements[i] = st.peek();
            }
        }
        return nextGreaterElements;
    }
    
    public int trap(int[] height) {
        int n = height.length;
        
        int[] nextPrevGreaterElements = getPrevGreaterElement(height);
        int[] nextGreaterElements = getNextGreaterElement(height);
        
        printTheArra(nextPrevGreaterElements);
        printTheArra(nextGreaterElements);
        
        int water = 0;
        
        for(int i = 0; i < n; i++){
            int diff = Math.min(nextPrevGreaterElements[i], nextGreaterElements[i]);
            if(diff > 0){
                water += Math.abs(height[i] - diff);
            }
        }
        
        return water;
    }
    
    private void printTheArra(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
/*


[0, 1, 0, 2, 1, 0, 1, 3,  2, 1, 2, 1]
-1 -1  1 -1  2  1  2 -1   3  2  3  2 
 1  2  2  3  3  1  3 -1   -1 2 -1 -1 
                |
                
      
      
      c = 1 + 1 + 1 + 1 + 1 + 

 


 
 
                     
                     
        
    height = [0,1,0,2,1,0,1,3,2,1,2,1]
                |
                 
                  
                water = 1 + 0 + 1 + 2 + 1 + 0 + 1 
               
               take the min height(leftHeight, rightHeight)
                                    3           2
               
               height - calculated height
             
    
     for each bar calculate the greatest bar to it's right position
     and to it's left position
     
     
     
     
     subproblem1:
            What is the next previous greater bar to the left
            next greater element to the left
            
            height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
                     -1 -1  1 -1  2  1  2 -1  3  2  3  3
                      
                     {
                       3,
                     }
                     
            1.) iterat through all the elements
                a.) keep poping out all the elements that are smaller than
                    the current bar
                
                b.) push the current element to the stack



    subproblem2:
                What is the next greater bar to the right
                next greater element to the right

                height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
                                                          -1
                                                           
                {
                  1,
                  
                }

                1.) iterat through all the elements in reverse order
                    a.) keep poping out all the elements that are smaller than
                        the current bar

                    b.) push the current element to the stack
                
                
            
            
            
            
     
     
     
    
    
    

        
    

*/