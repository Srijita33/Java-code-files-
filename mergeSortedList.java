import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class mergeSortedList{
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
    static Node mergeList(Node l1, Node l2){
        Node dummy=new Node(0);
        Node current=dummy;
        
        while(l1!=null &&l2!=null){
            if(l1.data<=l2.data){
                current.next=l1;
                l1=l1.next;
            }
            else{
                current.next=l2;
                l2=l2.next;
            }
            current=current.next;
        }
        if(l1!=null){
            current.next=l1;
        }
        else{
            current.next=l2;
        }
        return dummy.next;
        
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Node head1=null;
        Node head2=null;
        System.out.println("Enter the no of nodes in list1");
        int m=sc.nextInt();
        System.out.println("enter elements of 1st list");
        for(int i=0;i<m;i++){
            int val1=sc.nextInt();
            head1=insert(head1,val1);
        }
        System.out.println("Enter the no of nodes in list2");
        int n=sc.nextInt();
        System.out.println("enter elements of 2nd list");
        for(int i=0;i<n;i++){
            int val2=sc.nextInt();
            head2=insert(head2,val2);
        }
        
        System.out.println("Original lists were: ");
        printList(head1);
        printList(head2);
        Node newnode=mergeList(head1,head2);
        System.out.print("After merging ");
        printList(newnode);
        sc.close();
        
    }
}