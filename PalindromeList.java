import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class PalindromeList{
    static Node insertList(Node head, int val){
        Node newnode=new Node(val);
        if (head==null){
            return newnode;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        return head;
    }
    static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
        
    }
    static Node reverseList(Node head){
        if (head==null || head.next==null){
            return head;
        }
        Node prev=null;
        Node current=head;
        Node next;
        
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    static boolean palindromeList(Node head){
        if (head==null || head.next==null){
            return true;
        }
        Node temp=head;
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            }
        Node reverse2=reverseList(slow);
        Node firsthead=head;
        Node secondhead=reverse2;
        
        while(secondhead!=null){
            if(firsthead.data!=secondhead.data){
                return false;
            }
            secondhead=secondhead.next;
            firsthead=firsthead.next;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Node head=null;
        
        System.out.println("enter no of nodes");
        int n=sc.nextInt();
        
        System.out.println("enter nodes of linked list");
        for (int i=0;i<n;i++){
            int val=sc.nextInt();
            head=insertList(head,val);
        }
        
        System.out.println("Original list");
        printList(head);
        
        boolean flag=palindromeList(head);
        if(flag){
            System.out.println("its palindrome");
        }
        else{
            System.out.println("linked list not palindrome");
        }
        sc.close();
        
    }
    
    
    
    
    
    
    
    
    
}