import java.util.*;

public class circularQueDesign
{
    static int size,front,rear;
    static int[] que;
    
    public static void init(int n)
    {
        size=n;
        que=new int[n];
        front=rear=-1;
    }
    public static void enqueue(int n)
    {
        if((rear+1)%size == front){
            System.out.println("queue full");
            return;
        }
        if(front==-1) front=0;
        rear=(rear+1)%size;
        que[rear]=n;
        System.out.println(n+" inserted");
        
    }
    public static void dequeue()
    {
        if (front == -1){
            System.out.println("queue empty");
            return;
        }
        System.out.println("deleted : "+que[front]);
        if(front == rear){
            front=rear=-1;
            return;
        }else{
            front=(front+1)%size;
        }
    }
    public static void print()
    {
        if (front == -1){
            System.out.println("queue empty");
            return;
        }
        for(int i=front;i<=rear;i=(i+1)%size){
            System.out.print(que[i]+" ");
            if(i==rear) break;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int capacity=sc.nextInt();
        init(capacity);
        int n=sc.nextInt();
        while(n-->0)
        {
            String st=sc.next();
            switch(st)
            {
                case "enqueue":int val=sc.nextInt();
                                enqueue(val);
                                break;
                case "dequeue":dequeue();
                                break;
                case "print":print();
                             break;
                default:System.out.println("invalid input");
            }
        }
        
    }
}