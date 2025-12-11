import java.util.*;

public class kLargestInArray
{
    public static Random rand=new Random();
    public static int kthlargest(int[] nums, int k)
    {
        if(nums==null||nums.length == 0)return Integer.MIN_VALUE;
        int n=nums.length;
        if(k<=0 || k>n) return Integer.MIN_VALUE;
        return quickselect(nums,0,n-1,n-k);//n-kth smallest==kth largest
    }
    public static int quickselect(int[] nums,int left, int right, int ksmallest)
    {
        if(left==right) return nums[left];
        int pivotind=left+rand.nextInt(right-left+1);
        pivotind=partition(nums,left,right,pivotind);
        
        if(pivotind==ksmallest){
            return nums[pivotind];
        }
        else if(pivotind<ksmallest){
            return quickselect(nums,left,pivotind-1,ksmallest);
        }else{
            return quickselect(nums,pivotind+1,right,ksmallest);
        }
    }
    public static int partition(int[] nums,int left,int right,int pivotind)
    {
        int pivotval=nums[pivotind];
        swap(nums,pivotind,right);//move pivot to end
        int storeindex=left;
        
        for(int i=left;i<right;i++)
        {
            if(nums[i]<pivotval){
                swap(nums,storeindex,i);
                storeindex++;
            }
        }
        swap(nums,storeindex,right);//final move to place in right position
        return storeindex;
        
    }
    public static void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(kthlargest(arr,k));
    }
}