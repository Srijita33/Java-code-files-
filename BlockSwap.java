
import java.util.Scanner;
public class BlockSwap{
    static void blockSwap(int[] arr,int k){
        if (k==0) return;
        k=k%arr.length;
        if(k>arr.length) return;
        int n=arr.length;
        int[] temp=new int[k];
        for(int i=0;i<k;i++){
            temp[i]=arr[i];
        }
        for(int i=0;i<n-k;i++){
            arr[i]=arr[i+k];
        }
        for(int i=n-k;i<n;i++){
            arr[i]=temp[i-n+k];
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n= sc.nextInt();
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        System.out.println("Enter the value of k for blockswap");
        int k=sc.nextInt();
        blockSwap(arr,k);
        System.out.print("after swap : ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}