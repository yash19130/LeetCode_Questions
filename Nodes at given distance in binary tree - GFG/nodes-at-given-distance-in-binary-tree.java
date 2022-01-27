// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        HashMap<Node, Node> hp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if(root != null)
            q.add(root);
        Node temp = null;
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(node.data == target)
            {
                temp = node;
                break;
            }
            if(node.left != null)
            {
                hp.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null)
            {
                hp.put(node.right, node);
                q.add(node.right);
            }
        }
        HashSet<Node> vis = new HashSet<>();
        ArrayList<Integer> nodes = new ArrayList<>();
        solve(temp, k, nodes, hp, vis);
        Collections.sort(nodes);
        return nodes;
    }
    
    public static void solve(Node root, int k, ArrayList<Integer> nodes, 
                                HashMap<Node, Node> hp, HashSet<Node> vis)
    {
        if(root == null || k < 0 || vis.contains(root))
            return;
        vis.add(root);
        if(k == 0)
            nodes.add(root.data);
        if(hp.containsKey(root))
            solve(hp.get(root), k-1, nodes, hp, vis);
        solve(root.left, k-1, nodes, hp, vis);
        solve(root.right, k-1, nodes, hp, vis);
    }
}