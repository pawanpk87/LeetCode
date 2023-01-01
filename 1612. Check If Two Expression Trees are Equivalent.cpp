A binary expression tree is a kind of binary tree used to represent arithmetic expressions. Each node of a binary expression tree has either zero or two children. Leaf nodes (nodes with 0 children) correspond to operands (variables), and internal nodes (nodes with two children) correspond to the operators. In this problem, we only consider the '+' operator (i.e. addition).

You are given the roots of two binary expression trees, root1 and root2. Return true if the two 
binary expression trees are equivalent. Otherwise, return false.

Two binary expression trees are equivalent if they evaluate to the same value regardless of what the 
variables are set to.

 

Example 1:

Input: root1 = [x], root2 = [x]
Output: true
Example 2:



Input: root1 = [+,a,+,null,null,b,c], root2 = [+,+,a,b,c]
Output: true
Explaination: a + (b + c) == (b + c) + a
Example 3:



Input: root1 = [+,a,+,null,null,b,c], root2 = [+,+,a,b,d]
Output: false
Explaination: a + (b + c) != (b + d) + a
 

Constraints:

The number of nodes in both trees are equal, odd and, in the range [1, 4999].
Node.val is '+' or a lower-case English letter.
It's guaranteed that the tree given is a valid binary expression tree.
 

Follow up: What will you change in your solution if the tree also supports the '-' operator (i.e. subtraction)?
  
/**
 * Definition for a binary tree node.
 * struct Node {
 *     char val;
 *     Node *left;
 *     Node *right;
 *     Node() : val(' '), left(nullptr), right(nullptr) {}
 *     Node(char x) : val(x), left(nullptr), right(nullptr) {}
 *     Node(char x, Node *left, Node *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    void traverse(Node* root,int add,int mp[])
    {
        if(!root)
            return;
        if(root->val>='a' && root->val<='z')
            mp[root->val-'a']+=add;
        traverse(root->left,add,mp);
        traverse(root->right,add,mp);
    }
    
public:
    bool checkEquivalence(Node* root1, Node* root2) {
        int mp[26]={0};
        traverse(root1,1,mp);
        traverse(root2,-1,mp);
        for(auto& val : mp)
        {
            if(val != 0)
                return false;
        }
        return true;
    }
};

Follow up: 

class Solution {
private:
    void traverse(Node* root,int add,int mp[],int sign)
    {
        if(!root)
            return;
        
        if(root->val>='a' && root->val<='z')
            mp[root->val-'a']+=sign * add;
        
        traverse(root->left,add,mp,sign);
        
        if(root->val == '-')
            sign=-1*sign;
        
        traverse(root->right,add,mp,sign);
    }
    
public:
    bool checkEquivalence(Node* root1, Node* root2) {
        int mp[26]={0};
        traverse(root1,1,mp,1);
        traverse(root2,-1,mp,1);
        for(auto& val : mp)
        {
            if(val != 0)
                return false;
        }
        return true;
    }
};
