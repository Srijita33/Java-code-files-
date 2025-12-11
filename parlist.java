import java.util.*;
class Listnode{
    int val;
    Listnode next;
    Listnode(int x){
        val=x;
        next=null;
    }
}
public class parlist{
    public static Listnode partitionlist(Listnode head, int x){
        Listnode beforehead=new Listnode(0);
        Listnode afterhead= new Listnode(0);
        
        Listnode before=beforehead;
        Listnode after=afterhead;
        
        while(head!=null){
            if(head.val<x)
            {
                before.next=head;
                before=before.next;
            }else{
                after.next=head;
                after=after.next;
            }
            head=head.next;
        }
        after.next=null;
        before.next=afterhead.next;
        return beforehead.next;
    }
    public static Listnode insert(Listnode head, int val){
        Listnode newnode=new Listnode(val);
        if(head==null) return newnode;
        else{
            Listnode temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
            return head;
        }
    }
    public static void printList(Listnode head){
        Listnode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Listnode head1=null;
        
        System.out.println("enter the length of llist");
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            int val=sc.nextInt();
            head1=insert(head1,val);
        }
        System.out.println("enter x");
        int x=sc.nextInt();
        
        printList(head1);
        
        Listnode newl=partitionlist(head1,x);
        System.out.println("after partition :");
        printList(newl);
        
    }
}

