import java.util.*;
public class LongestValidParanthesisLen{
    public static int LongValidPlen(String s){
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int maxlength=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) =='('){
                stack.push(i);
            }
            else if(s.charAt(i)==')'){
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else{
                    maxlength=Math.max(maxlength, i-stack.peek());
                }
            }
        }
        return maxlength;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("ENter string with (,)");
        String input=sc.nextLine();
        
        System.out.println("longest valid paranthesis of length " + LongValidPlen(input));
        
    }
}