// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution
{
    Node head, tail;
    
    void addNode(int data)
    {
        Node node = new Node(data);
        if(head == null)
            head = node;
        else
            tail.next = node;
        tail = node;
    }
    
    static Node reverse(Node head)
    {
        Node temp = head, prev = null, next = null;
        while(temp != null)
        {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
    
    static Node addTwoLists(Node head1, Node head2)
    {
        head1 = reverse(head1);
        head2 = reverse(head2);
        boolean carry = false;
        Node t1 = head1, t2 = head2;
        Solution ll = new Solution();
        while(t1 != null && t2 != null)
        {
            int sum = t1.data + t2.data;
            if(carry)
            {
                sum++;
                carry = false;
            }
            if(sum > 9)
            {
                ll.addNode(sum-10);
                carry = true;
            }
            else
                ll.addNode(sum);
            t1 = t1.next;
            t2 = t2.next;
        }
        while(t1 != null)
        {
            int sum = t1.data;
            if(carry)
            {
                sum++;
                carry = false;
            }
            if(sum > 9)
            {
                ll.addNode(sum-10);
                carry = true;
            }
            else
                ll.addNode(sum);
            t1 = t1.next;
        }
        while(t2 != null)
        {
            int sum = t2.data;
            if(carry)
            {
                sum++;
                carry = false;
            }
            if(sum > 9)
            {
                ll.addNode(sum-10);
                carry = true;
            }
            else
                ll.addNode(sum);
            t2 = t2.next;
        }
        if(carry)
            ll.addNode(1);
        return reverse(ll.head);
    }
}