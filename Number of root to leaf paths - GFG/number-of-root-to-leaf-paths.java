// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
	int data;
	Node left, right;
	Node(int d)
	{
		data = d;
		left = right = null;
	}
}

class Roof_To_Leaf_Paths_Having_Equal_Length
{
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
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
	public static void main(String args[]) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t>0)
		{
		    String s = br.readLine();
	    	Node root = buildTree(s);
			GfG g = new GfG();
			g.countPaths(root);
			System.out.println();
		    t--;
		}
	}
}// } Driver Code Ends


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */


class GfG
{
    void countPaths(Node root)
    {
        Map<Integer, Integer> tp = new TreeMap<>();
        solve(root, tp, 0);
        for(int k: tp.keySet())
            System.out.print(k + " " + tp.get(k) + " $"); 
    }
    
    void solve(Node root, Map<Integer, Integer> tp, int elements)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            tp.put(elements+1, tp.getOrDefault(elements+1, 0) + 1);
        solve(root.left, tp, elements+1);
        solve(root.right, tp, elements+1);
    }
}
