//nth digit
import java.util.*;
public class Main{
    public static int nthDigit(int n){
        long digitlen=1;
        long count=9;
        long start=1;
        while(n>digitlen*count){
            n-=digitlen*count;
            digitlen++;
            count*=10;
            start*=10;
        }
        long num=start+(n-1)/digitlen;
        String st=Long.toString(num);
        int index=(n-1)%(int)digitlen;
        
        return st.charAt(index)-'0';
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(nthDigit(n));
    }
}
