import java.util.*;
public class validateParanthesis{
    public static boolean validParanthesis(String s){
        Stack<Character> stack=new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch =='(' ||ch=='{' ||ch=='['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) return false;
                char top=stack.pop();
                if( (ch==')' && top!='(' )||
                    (ch=='}' && top!='{' )||
                    (ch==']' && top!='[' ) ) return false;    
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string of parathesis to validate");
        String input=sc.nextLine();
        boolean res=validParanthesis(input);
        if(res) System.out.println(input+" valid seq");
        else System.out.println(input +" not a valid seq");
    }
}