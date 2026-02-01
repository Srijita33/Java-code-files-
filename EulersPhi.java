import java.util.*;
public class Main{
    public static int phi(int n)
    {
        int result=n;
        for(int p=2;p*p<=n;p++)
        {
            if(n%p==0){
                while(n%p==0){
                    n/=p;//remove all p factor
                }
                result-=result/p;//phi formula
            }
        }
        if(n>1){
            result-=result/n;
        }
        return result;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(phi(n));
    }
}
