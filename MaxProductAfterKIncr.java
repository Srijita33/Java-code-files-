import java.util.*;
public class MaxProductAfterKIncr
{
    public static final Long MOD=1_000_000_007L;
    public static int maxproductki(int[] nums,int k)
    {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length;
        
        PriorityQueue<Long> minheap=new PriorityQueue<>();
        for(int x:nums)minheap.offer((long)x);
        while(k>0 && !minheap.isEmpty())
        {
            long smallest=minheap.poll();
            int count=1;
            while(!minheap.isEmpty()&&minheap.peek().longValue()==smallest)
            {
                minheap.poll();
                count++;
            }
            long next=minheap.isEmpty()?Long.MAX_VALUE:minheap.peek();
            long diff=(next==Long.MAX_VALUE)?Long.MAX_VALUE:(next-smallest);
            
            if(diff==0||next==Long.MAX_VALUE)
            {
               long addper= k/count;
               long rem=k % count;
               long baseval=smallest+addper;
               for(int i=0;i<count-(int)rem;i++)minheap.offer(baseval);
               for(int i=0;i<rem;i++)minheap.offer(baseval+1);
               k=0;
            }
            else{
                long totalneed=diff*(int)count;
                if(k>=totalneed){
                    minheap.offer(next);
                    k-=totalneed;
                    
                }
                else{
                   long addper= k/count;
                   long rem=k % count;
                   long baseval=smallest+addper;
                   for(int i=0;i<count-(int)rem;i++)minheap.offer(baseval);
                   for(int i=0;i<rem;i++)minheap.offer(baseval+1);
                   k=0;
                }   
                }
            }
            long product=1L;
            while(!minheap.isEmpty())
            {
                long v=minheap.poll()%MOD;
                product=(product*v)%MOD;
            }
            return (int)product;
        }
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(maxproductki(nums,k));
    }
}