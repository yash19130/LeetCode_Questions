// { Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            Solution x = new Solution();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        }
    }
}

// } Driver Code Ends


/*
// node structure:

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/

class Solution
{
    static int sum_at_distK(Node root, int target, int k)
    {
        Map<Node, Node> hp = new HashMap<>();
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
        return solve(temp, k, hp, new HashSet<>());
    }
    
    static int solve(Node root, int k, Map<Node, Node> hp, Set<Node> vis)
    {
        if(root == null || k < 0 || vis.contains(root))
            return 0;
        vis.add(root);
        int p = 0;
        if(hp.containsKey(root))
            p = solve(hp.get(root), k-1, hp, vis);
        int l = solve(root.left, k-1, hp, vis);
        int r = solve(root.right, k-1, hp, vis);
        return root.data + p + l + r;
    }
}