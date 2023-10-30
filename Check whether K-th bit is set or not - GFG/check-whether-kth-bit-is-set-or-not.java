//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java
class CheckBit{
    static boolean checkKthBit(int n, int k){
        return ((1<<k) & n) != 0 ? true : false;
    }
}

//{ Driver Code Starts.

class GFG
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			k = Integer.parseInt(br.readLine()); // Input K
			
			CheckBit obj = new CheckBit();
			
			if(obj.checkKthBit(n, k))
				System.out.println("Yes"); //If true, print Yes
				
			else
				System.out.println("No");	// Else print No
            
            t--;
		}
	}
	
	
}
// } Driver Code Ends