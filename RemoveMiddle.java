
import java.util.*;
class Node{
    int data;
    Node next;
    
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class RemoveMiddle{
    public static Node Insert(Node head, int val){
        Node newnode=new Node(val);
        if(head==null){
            return newnode;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        return head;
    }
    public static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    static Node removeMiddle(Node head){
        Node prev=null;
        Node slow=head;
        Node fast=head;
        
        while(fast!=null&& fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=slow.next;
        return head;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of linked list");
        int n=sc.nextInt();
        Node head=null;
        System.out.println("enter node values:");
        for(int i=0;i<n;i++){
            System.out.println("node:"+(i+1));
            int val=sc.nextInt();
            head=Insert(head,val);
            
        }
        
        
        System.out.print("the original linked list :");
        printList(head);
        
        Node newhead=removeMiddle(head);
        System.out.print("new list :");
        printList(newhead);
        
        
    }
}