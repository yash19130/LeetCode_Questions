/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution 
{
    public Node flatten(Node head) 
    {
        Node temp = head;
        while(temp != null)
        {
            if(temp.child != null)
            {
                Node childTemp = temp.child;
                while(childTemp.next != null)
                    childTemp = childTemp.next;
                Node tempNext = temp.next;
                temp.next = temp.child;
                temp.child.prev = temp;
                childTemp.next = tempNext;
                temp.child = null;
                if(tempNext != null)
                    tempNext.prev = childTemp;
            }
            temp = temp.next;
        }
        return head;
    }
}