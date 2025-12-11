import java.util.*;
public class numberRecentCall
{
    static Deque<Integer> q=new ArrayDeque<>();
    public static int ping(int t)
    {
        q.addLast(t);
        while(!q.isEmpty() && q.peekFirst()< t-3000)
        {
            q.removeFirst();
        }
        return q.size();
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        while(n-->0)
        {
            int t=sc.nextInt();
            System.out.println(ping(t));
        }
        
    }
}