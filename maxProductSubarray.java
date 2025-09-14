import java.util.Scanner;
import java.lang.*;
public class maxProductSubarray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("enter array elements");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int prefix=0;
        int suffix=0;
        int result=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            
            prefix=prefix*arr[i];
            suffix=suffix*arr[n-i-1];
            
            result=Math.max(result,Math.max(prefix,suffix));
        }
        
        System.out.println("max product subarray "+result);
        
    }
}