
import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class rotataeNodeL{
    static Node insertList(Node head, int val){
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
    static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    static Node rotateNodeLeft(Node head, int k){
        if(head==null || head.next==null|| k==0){
            return head;
        }
        int length=1;
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
            length++;
        }
        k=k%length;
        if(k==0) return head;
        Node newTail=head;
        for(int i=1;i<k;i++){
            newTail=newTail.next;
        }
        Node newHead=newTail.next;
        newTail.next=null;
        tail.next=head;
        return newHead;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of nodes");
        int n= sc.nextInt();
        Node head=null;
        System.out.println("Enter the linked list elements");
        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            head=insertList(head,val);
        }
        System.out.println("enter the value of k");
        int k=sc.nextInt();
        System.out.print("Orginal list  :");
        printList(head);
        Node newNode=rotateNodeLeft(head,k);
        System.out.println("After rotation");
        printList(newNode);
        
        
    }
}
