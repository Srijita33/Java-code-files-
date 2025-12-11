import java.util.*;
public class kPairSmallestSum
{
    public static List<List<Integer>> kPairSmSum(int[] nums1,int[] nums2,int k)
    {
        int n1=nums1.length;
        int n2=nums2.length;
        List<List<Integer>> result=new ArrayList<>();
        if(nums1==null||nums2==null||n1==0||n2==0||k<=0){
            return result;
        }
        
        PriorityQueue<int[]> minheap=new PriorityQueue<>(Comparator.comparingLong(a -> (long)a[0]));
        int limit=Math.min(k,n1);
        for(int i=0;i<limit;i++)
        {
            minheap.offer(new int[]{nums1[i]+nums2[0],i,0});
        }
        
        while(k-->0 && !minheap.isEmpty())
        {
            int[] current=minheap.poll();
            int i=current[1];
            int j=current[2];
            
            result.add(Arrays.asList(nums1[i],nums2[j]));
            if(j+1<n2){
                minheap.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
                
            }
        }
        return result;
    
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums1=new int[n];
        for(int i=0;i<n;i++) nums1[i]=sc.nextInt();
        
        int m=sc.nextInt();
        int[] nums2=new int[m];
        for(int j=0;j<m;j++) nums2[j]=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(kPairSmSum(nums1,nums2,k));
    }
}