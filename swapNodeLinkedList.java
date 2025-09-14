import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class swapNodeLinkedList{
    static Node insertList(Node head, int val){
        Node newnode=new Node(val);
        if(head==null){
            return newnode;
        }
        Node temp=head;
        while (temp.next!=null){
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
    static Node swapNodeList(Node head, int k){
        int length=0;
        Node temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        if(k>length) return head;
        Node first=head;
        for(int i=1;i<k;i++){
            first=first.next;
        }
        Node second=head;
        for (int i=1;i<length-k+1;i++){
            second=second.next;
        }
        int tempdata=first.data;
        first.data=second.data;
        second.data=tempdata;
        
        return head;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Node head=null;
        
        
        System.out.println("enter the no of nodes:n");
        int n=sc.nextInt();
        System.out.println("enter "+n+" elements");
        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            head=insertList(head,val);
        }
        System.out.println("insert the value of k");
        int k=sc.nextInt();
        System.out.println("Original List");
        printList(head);
        
        
        System.out.println("after swapping");
        Node newnode1=swapNodeList(head,k);
        printList(newnode1);
        
        
    }
}