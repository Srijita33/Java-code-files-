import java.util.*;
public class MaxSumKSubsequence
{
    public static int[] MaxSumSubseq(int[] nums,int k){
        int n=nums.length;
        if(k<=0) return new int[0];
        if(k>=n) return Arrays.copyOf(nums,n);
        
        int [][] indexed=new int[n][2];
        for(int i=0;i<n;i++){
            indexed[i][0]=nums[i];
            indexed[i][1]=i;
        }
        
        Arrays.sort(indexed,(a,b)->Integer.compare(b[0],a[0]));
        int[][] topk=new int[k][2];
        topk=Arrays.copyOfRange(indexed,0,k);
        Arrays.sort(topk,Comparator.comparingInt(a->a[1]));
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=topk[i][0];
        }
        return result;
        
    }
    
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       int n;
       n=sc.nextInt();
       int[] nums=new int[n];
       for(int i=0;i<n;i++){
           nums[i]=sc.nextInt();
       }
       int k=sc.nextInt();
       int[] result=new int[k];
       result=(MaxSumSubseq(nums,k));
       for(int np:result){
           System.out.print( np+" ");
       }
    }
}