// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class SortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) 
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);
            
            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    
    public static void addToTheLast(Node node) 
{
  if (head == null) 
  {
    head = node;
  } else 
  {
   Node temp = head;
   while (temp.next != null)
          temp = temp.next;
         temp.next = node;
  }
}
}// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
class GfG
{
    public static Node quickSort(Node head)
    {
        if(head == null)
            return null;
        Node pivot = head;
        head = head.next;
        pivot.next = null;
        if(head == null)
            return pivot;
        Node p = pivot;
        Node small=new Node(0);
        Node large = new Node(0);
        Node s= small;
        Node l= large;
        //putting pivot at right position
        while(head!=null){
            if(head.data<pivot.data){
                s.next = head;
                s=s.next;
               
            }
            else if(head.data>pivot.data){
                l.next =head;
                l=l.next;
            }
            else{
                p.next = head;
                p=p.next;
            }
            head= head.next;
        }
        l.next = null;
        s.next= null;
        p.next= null;
        Node ss= quickSort(small.next);
        if(ss==null)
            ss=pivot;
        else{
            Node curr = ss;
            while(curr.next!= null)
                curr = curr.next;
            curr.next = pivot;
        }
        p.next = quickSort(large.next);
        return ss;
    }
    
    
    
    
}