// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Sol obj = new Sol();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
    Node head, tail;
    public void addNode(Node node)
    {
        if(head == null)
            head = node;
        else
            tail.next = node;
        tail = node;
    }
    
    public static Node findIntersection(Node head1, Node head2)
    {
        Node t1 = head1, t2 = head2;
        Sol ll = new Sol();
        while(t1 != null && t2 != null)
        {
            if(t1.data < t2.data)
                t1 = t1.next;
            else if(t1.data > t2.data)
                t2 = t2.next;
            else
            {
                ll.addNode(t1);
                t1 = t1.next;
                t2 = t2.next;
            }
        }
        return ll.head;
    }
}