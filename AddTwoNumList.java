import java.util.*;
class Listnode{
    int val;
    Listnode next;
    Listnode(int x){
        val=x;
        next=null;
    }
}
public class AddTwoNumList{
    public static Listnode addTwoList(Listnode l1,Listnode l2){
        Listnode dummy=new Listnode(0);
        Listnode current=dummy;
        int carry=0;
        
        while(l1!= null || l2!=null){
            int x=(l1!=null)?l1.val:0;
            int y=(l2!=null)?l2.val:0;
            int sum = x+y+ carry;
            carry=sum/10;
            
            current.next=new Listnode(sum%10);
            current=current.next;
            
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            
        }
        while(carry>0){
            current.next=new Listnode(carry);
        }
        return dummy.next;
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
        Listnode head1=null, head2=null;
        
        System.out.println("enter the length of 1st llist");
        int m=sc.nextInt();
        for(int i=0;i<m;i++){
            int val=sc.nextInt();
            head1=insert(head1,val);
        }
        
        System.out.println("enter the length of 2nd llist");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            head2=insert(head2,val);
            
        }
        
        printList(head1);
        printList(head2);
        Listnode newl=addTwoList(head1,head2);
        System.out.println("after addition :");
        printList(newl);
        
    }
}

