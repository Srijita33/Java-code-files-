import java.util.*;
public class removeKDigits{
    public static String removeKDigits(String num, int k){
        Stack<Character> stack=new Stack<>();
        for(char digit:num.toCharArray()){
            while(k>0 && !stack.isEmpty() && stack.peek()>digit)
            {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        //still k>0 for seq like 12345
        while(k>0 && !stack.isEmpty())
        {
            stack.pop();
            k--;
        }
        
        //result in stringbuilder
        StringBuilder sb=new StringBuilder();
        for (char ch:stack) sb.append(ch);
        
        //remove leading 0's
        while(sb.length()>1 && sb.charAt(0)=='0')
        {
            sb.deleteCharAt(0);
        }
        
        return (sb.length()==0 ?"0":sb.toString());
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string");
        String input=sc.nextLine();
        System.out.println("enter k (digits to be removed)");
        int k=sc.nextInt();
        
        System.out.println("smallest digit after remove "+removeKDigits(input,k));
    }
}