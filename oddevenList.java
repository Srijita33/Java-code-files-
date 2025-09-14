
import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class oddevenList{
    static Node insert(Node head,int val){
       Node newnode=new Node(val);
       if(head==null) return newnode;
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
    static Node oddevenByPosition(Node head){
        Node odd=head;
        Node even=head.next;
        Node evenHead=even;
        
        while(even!=null &&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
        
    }
    static Node oddevenByValue(Node head){
        Node current=head;
        
        Node oddhead=null,oddtail=null;
        Node evenhead=null,eventail=null;
        
        while(current!=null){
            Node nextnode=current.next;
            current.next=null;
            if(current.data%2!=0){
                if(oddhead==null){
                    oddhead=oddtail=current;
                }
                else{
                    oddtail.next=current;
                    oddtail=current;
                }
            }
            else{
                if(evenhead==null){
                    evenhead=eventail=current;
                }
                else{
                    eventail.next=current;
                    eventail=current;
                }
            }
            current=nextnode;
        }
        if(oddtail!=null) oddtail.next=evenhead;
        if(eventail!=null) eventail.next=null;
        
        if(oddhead!=null) return oddhead;
        else{
            return evenhead;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Node head=null;
        System.out.println("Enter the no of nodes in list1");
        int m=sc.nextInt();
        System.out.println("enter elements of list");
        for(int i=0;i<m;i++){
            int val1=sc.nextInt();
            head=insert(head,val1);
        }
        
        System.out.println("Original lists were: ");
        printList(head);
        Node headh=head;
        Node oepos=oddevenByPosition(head);
        System.out.print("Odd even by position: ");
        printList(oepos);
        Node oeval=oddevenByValue(headh);
        System.out.print("Odd even by value: ");
        printList(oeval);
        sc.close();
    }
}
