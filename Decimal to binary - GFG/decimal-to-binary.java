//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0) {
			int N = sc.nextInt();
			Solution obj = new Solution();
			obj.toBinary(N);
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	void toBinary(int N) {
	    ArrayList<Integer> bits = new ArrayList<>();
		
		while(N > 0){
		    bits.add(N%2);
		    N = N/2;
		}
		
		for(int i = bits.size()-1; i >= 0; i--){
		    System.out.print(bits.get(i));
		}
	}
}