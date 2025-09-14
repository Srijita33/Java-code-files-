
import java.io.*;
import java.util.*;
public class betterMaxProduct{
    static int maxSubSum(int[] arr,int n){
        int maxendhere=arr[0];
        int minendhere=arr[0];
        int maxsofar=arr[0];
        
        for(int i=1;i<n;i++){
            int temp=Math.max(Math.max(arr[i],arr[i]*maxendhere),arr[i]*minendhere);
            minendhere=Math.min(Math.min(arr[i],arr[i]*maxendhere),arr[i]*minendhere);
            maxendhere=temp;
            maxsofar=Math.max(maxsofar,maxendhere);
        }
        return maxsofar;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int pro=maxSubSum(arr,n);
        System.out.println("Maximum subarray produuct "+pro);
        sc.close();
    }
}