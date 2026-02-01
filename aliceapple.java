import java.util.*;
public class Main{
    public static int aliceapple(int m,int k,int n,int s,int e,int w){
        if(m<=s*k)
            return m;
        else if (m<=s*k+e+w)
            return s*k+(m-s*k);
        else
            return -1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        String[] parts=st.split(" ");
        int m=Integer.parseInt(parts[0]);
        int k=Integer.parseInt(parts[1]);
        int n=Integer.parseInt(parts[2]);
        int s=Integer.parseInt(parts[3]);
        int e=Integer.parseInt(parts[2]);
        int w=Integer.parseInt(parts[3]);
        
        System.out.println(aliceapple(m,k,n,s,e,w));
        
    }
}
