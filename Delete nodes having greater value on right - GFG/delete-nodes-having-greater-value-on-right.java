//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node newRoot;
    
    void createNewList(Node currNode){
        if(currNode == null)
            return;
        
        Node nextNode = currNode;
        
        createNewList(currNode.next);
        
        if(newRoot.data <= nextNode.data){
            newRoot.next = new Node(nextNode.data);
            newRoot = newRoot.next;
        }
    }
    
    Node reverseList(Node head){
        Node prevNode = null;
        Node nextNode = null;
        Node currNode = head;
        
        while(currNode != null){
            nextNode =  currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        
        return prevNode;
    }
    
    Node compute(Node head){
        newRoot = new Node(-1);
        Node newRootNode = newRoot;
        createNewList(head);
        return reverseList(newRootNode.next);
    }
}
  