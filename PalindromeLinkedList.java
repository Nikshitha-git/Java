/*
1.	Palindrome Linked List:

	Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input:
head = [1,2,2,1]
Output: 
true

Example 2:
Input: 
head = [1,2]
Output: 
false


case=1
input =1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1
output =true

case=2
input =1 2 3 4 5 6 7 8 9 8 9 7 6 5 4 3 2 1
output =false

Approach:
----------
The solution approach follows the intuition which is broken down into the following algorithms and patterns:
1.	Two-pointer technique: To find the middle of the list, we use two pointers (slow and fast). The slow pointer is incremented by one node, while the fast pointer is incremented by two nodes on each iteration. When the fast pointer reaches the end, slow will be pointing at the middle node.
1.slow, fast = head, head.next
2.while fast and fast.next:
3.slow, fast = slow.next, fast.next.next
2. Reversing the second half of the list: Once we have the middle node, we reverse the second half of the list starting from slow.next. To do this, we initialize two pointers pre (to keep track of the previous node) and cur (the current node). We then iterate until cur is not None, each time setting cur.next to pre, effectively reversing the links between the nodes.
1. pre, cur = None, slow.next
2. while cur:
3.   t = cur.next
4.   cur.next = pre
5.    pre, cur = cur, t
3. Comparison of two halves: After reversing the second half, pre will point to the head of the reversed second half. We compare the values of the nodes starting from head and pre. If at any point the values differ, we return False indicating that the list is not a palindrome. Otherwise, we keep advancing both pointers until pre is None. If we successfully reach the end of both halves without mismatches, the list is a palindrome, so we return True.
1 while pre:
2    if pre.val != head.val:
3        return False
4    pre, head = pre.next, head.next
5 return True


*/



import java.util.*;

class Node
{    
	int data;    
	Node next;    
	
	public Node(int data) 
	{    
		this.data = data;    
		this.next = null;    
	}    
}    

class Solution
{
    //Function to check whether the list is palindrome.
    Node getmid (Node head)
    {
        Node slow =  head ;  
        Node fast =  head.next ;
        
        while(fast !=  null && fast.next != null )
        {
            fast =  fast.next.next ;  
            slow =  slow.next ;  
        }
        return slow ;  
    }
    Node reverse(Node head){
        Node curr  =  head ;  
        Node prev =  null  ;  
        Node next =  null ;  
        
        while(curr !=  null)
        {
            next =  curr.next ;  
            curr.next  =  prev  ; 
            prev = curr ;  
            curr =  next ;  
        }
        return prev ;  
    }
      
     boolean isPalindrome(Node head) 
    {
        if(head.next ==  null)
        {
            return true ;  
        }
        
        Node middle =  getmid(head);
        
        Node temp  =  middle.next   ;  
        middle.next =  reverse(temp);
        
        Node head1  =  head ;  
        Node head2 =  middle.next ;  
        
        while(head2 !=  null)
        {
            if(head1.data !=  head2.data)
            {
                return false ; 
            }
            head1 =  head1.next ;  
            head2 =  head2.next ;  
        }
        
        temp  =  middle.next ;
        middle.next =  reverse(temp);
        
        return true ;  
    }    
}
class PalindromeList
 {    
    public Node head = null;    
    public Node tail = null;    
        
    public void addNode(int data) 
     {    
        Node newNode = new Node(data);    
        if(head == null) 
        {    
            head = newNode;    
            tail = newNode;    
        }  
        else 
      {    
           tail.next = newNode;    
            tail = newNode;    
        }    
    }    
        
    public static void main(String[] args) 
    {    
        Scanner sc=new Scanner(System.in);
        PalindromeList list= new PalindromeList();       
        String list2[]=sc.nextLine().split(" "); 
		for(int i=0;i<list2.length;i++)
			list.addNode(Integer.parseInt(list2[i]));
		Solution sl=new Solution();
		System.out.println(sl.isPalindrome(list.head));
    }    
}    


