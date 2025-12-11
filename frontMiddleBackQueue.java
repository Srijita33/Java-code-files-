import java.util.*;

public class frontMiddleBackQueue
{
    public static Deque<Integer> left=new LinkedList<>();
    public static Deque<Integer> right=new LinkedList<>();
    
    public static void rebalance()
    {
        while(left.size()>right.size())
        {
            right.addFirst(left.removeLast());
        }
        while(right.size()>left.size()+1){
            left.addLast(right.removeFirst());
        }
    }
    public static void pushfront(int val)
    {
        left.addFirst(val);
        rebalance();
    }
    public static void pushmiddle(int val)
    {
        left.addLast(val);
        rebalance();
    }
    public static void pushback(int val)
    {
        right.addLast(val);
        rebalance();
    }
    public static int popfirst()
    {
        if(left.isEmpty() && right.isEmpty())return -1;
        int val= !left.isEmpty()?left.removeFirst():right.removeFirst();
        rebalance();
        return val;
    }
    public static int popmiddle()
    {
        if(left.isEmpty() && right.isEmpty())return -1;
        int val= !left.isEmpty()?left.removeLast():right.removeFirst();
        rebalance();
        return val;
    }
    public static int popback()
    {
        if(left.isEmpty() && right.isEmpty())return -1;
        int val= !right.isEmpty()?right.removeLast():left.removeLast();
        rebalance();
        return val;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int val;
        while(n-->0)
        {
            String op=sc.next().toLowerCase();
            switch(op)
            {
                case "pushfront":val=sc.nextInt();
                                 pushfront(val);
                                 break;
                case "pushmiddle":val=sc.nextInt();
                                 pushmiddle(val);
                                 break;
                case "pushback":val=sc.nextInt();
                                pushback(val);
                                break;
                case "popfront":val=popfirst();
                                System.out.println(val);
                                break;
                case "popmiddle":val=popmiddle();
                                System.out.println(val);
                                break;
                case "popback":val=popback();
                                System.out.println(val);
                                break;
                default:System.out.println("invalid input");
                
            }
        }
        
    }
}