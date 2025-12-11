import java.util.*;
public class ValidateStackSeq{
    public static boolean ValidateStackSeq(int[] pushed, int[] popped){
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for (int x:pushed){
            stack.push(x);
            
            while(!stack.isEmpty() && j<popped.length && stack.peek()==popped[j])
            {
               stack.pop();
               j++;
            }
        }
        return j==popped.length;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        //take input as array of strings
        System.out.println("Enter 1st pushed seq space separated order");
        String[] pushstr=sc.nextLine().split(" ");
        int[] pushed=new int[pushstr.length];
        for(int i=0;i<pushstr.length;i++){
            pushed[i]=Integer.parseInt(pushstr[i]);
        }
        
        System.out.println("Enter 2nd popped seq space separated order");
        String[] popstr=sc.nextLine().split(" ");
        int[] popped=new int[popstr.length];
        for(int i=0;i<popstr.length;i++){
            popped[i]=Integer.parseInt(popstr[i]);
        }
        
        System.out.println("is valid? " + ValidateStackSeq(pushed,popped));
    }
}