
import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class removeKth{
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
    static Node removeKthfromEnd(Node head, int k){
        Node dummy=new Node(0);
        dummy.next=head;
        Node fast=dummy;
        Node slow=dummy;
        
        for(int i=0;i<=k;i++){
            if(fast!=null){
                fast=fast.next;
            }
            else{
                return head;
            }
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
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
        
        System.out.println("enter which node from last you want to remove");
        int k=sc.nextInt();
        Node newnode=removeKthfromEnd(head,k);
        System.out.println("after deletion:");
        printList(newnode);
        sc.close();
        
    }
    
    
    
    
    
    
    
    
    
}