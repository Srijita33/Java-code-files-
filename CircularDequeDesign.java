import java.util.*;
public class CircularDequeDesign
{
    static int size,front,rear;
    static int[] deque;
    public static void init(int capacity)
    {
        size=capacity;
        deque=new int[size];
        front=rear=-1;
    }
    public static boolean isfull()
    {
        return ((rear+1)%size==front);
    }
    public static boolean isempty()
    {
        return (front==-1);
    }
    public static void insertfront(int val)
    {
        if(isfull()){
            System.out.println("overflow");
            return;
        }
        if(isempty())front=rear=0;
        front=(front-1+size)%size;
        deque[front]=val;
        
        System.out.println(val+" inserted at front");
    }
    public static void insertrear(int val)
    {
        if(isfull())
        {
            System.out.println("overflow");
            return;
        }
        if(isempty())front=rear=0;
        rear=(rear+1)%size;
        deque[rear]=val;
        System.out.println(val+" inserted at rear");
    }
    public static void deletefront()
    {
        if(isempty())
        {
            System.out.println("underflow");
            return;
        }
        System.out.println("Deleted :"+deque[front]);
        front=(front+1)%size;
    }
    public static void deleterear()
    {
        if(isempty())
        {
            System.out.println("underflow");
            return;
        }
        System.out.println("Deleted :"+deque[rear]);
        rear=(rear-1+size)%size;
    }
    public static void printq()
    {
        if(isempty())
        {
            System.out.println("underflow");
            return;
        }
        for(int i=front;;i=(i+1)%size)
        {
            System.out.print(deque[i]+" ");
            if(i==rear) break;
        }
        
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
                case "insertfront": int val=sc.nextInt();
                                    insertfront(val);
                                    break;
                case "insertrear":  int val2=sc.nextInt();
                                    insertrear(val2);
                                    break;
                case "deletefront": deletefront();
                                    break;
                case "deleterear":  deleterear();
                                    break;
                case "print":printq();
                             break;
                default:System.out.println("invalid input");
            }
        }
    }
}