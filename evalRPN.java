import java.util.*;
public class evalRPN{
    public static int evalRPN(String[] tokens){
        Stack<Integer> stack=new Stack<>();
        for(String token: tokens){
            if("+-*/%".contains(token)){
                int b=stack.pop();
                int a=stack.pop();
                switch(token){
                    case "+":stack.push(a+b);break;
                    case "-":stack.push(a-b);break;
                    case "*":stack.push(a*b);break;
                    case "/":stack.push(a/b);break;
                    case "%":stack.push(a%b);break;
                }
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();   
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        
        System.out.println("enter reverpolish notation space separate");
        String input = sc.nextLine();
        String[] tokens=input.split(" ");
        //space separted value goes inside array of strings
        System.out.println( Arrays.toString(tokens)+" = "+evalRPN(tokens));
        
    }
}