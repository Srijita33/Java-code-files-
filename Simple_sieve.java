
//simple sieve-find primes upto a given no:

import java.util.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        boolean prime[]=new boolean[num+1];//num+1 because its upto num not before num
        for(int i=0;i<prime.length;i++){
            prime[i]=true;
        }
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<=Math.sqrt(num);i++)
        {
            if(prime[i]){
                for(int j=i*i;j<=num;j+=i){
                    prime[j]=false;
                }
            }
        }
        for(int i=0;i<prime.length;i++){
            if(prime[i]==true){
                System.out.print(i+" ");
            }
        }
    }
}
