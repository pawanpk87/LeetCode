//{ Driver Code Starts
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution {
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[]){
        int n = petrol.length;
        
        int start = 0;
        int end = 1;
        int currPetrol = petrol[0] - distance[0];
        
        while(start != end || currPetrol < 0) {
            
            // exclude the start if condition is not satisfied
            while(currPetrol < 0 && start != end) {
                // exclude the start
                currPetrol = currPetrol - petrol[start] + distance[start];
                start = (start + 1) % n;
                
                // if 0 is consider start again then there is no answer
                if(start == 0) {
                    return -1;
                }
            }
            
            // include the current element
            currPetrol = currPetrol + petrol[end] - distance[end];
            
            end = (end + 1) % n;
        }
        
        return start;
    }
}
