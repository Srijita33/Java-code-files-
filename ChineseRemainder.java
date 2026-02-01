import java.util.*;
public class Main{
    
    public static int crt(int a[], int m[], int n, int totalpro)
    {
        int x=0;//result
        for(int i=0;i<n;i++){
            int partialpro=totalpro/m[i];
            int inverse=0;
            //inverse modulo of partialproduct %m[i]
            for(int j=1;j<m[i];j++){
                if((partialpro*j)%m[i]==1){
                    inverse=j;
                    break;
                }
            }
            x+=a[i]*partialpro*inverse;
        }
        return x%totalpro;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int totalpro=1;
        int a[]=new int[n];
        int m[]=new int[n];
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            m[i]=sc.nextInt();
            totalpro*=m[i];
        }
        System.out.println(crt(a,m,n,totalpro));
    }
}
