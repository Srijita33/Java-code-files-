import java.util.*;
public class calculate{
    public static int calculate(String s){
        Stack<Integer> stack=new Stack<>();
        int result=0;
        int sign=1;
        int num=0;
        for(int i=0;i<s.length();i++)
        {
            char ch= s.charAt(i);
            if(Character.isDigit(ch))
            {
               num=num*10+(ch-'0'); 
            }else if(ch == '+'){
                result+=num*sign;   //add last num in result
                num=0;  //reset current no
                sign=1; //next no will be positive
            }else if(ch == '-'){
                result+=num*sign;
                num=0;
                sign=-1;
            }else if(ch== '('){
                stack.push(result); //save old rsult
                stack.push(sign);   //save old sign
                result=0;   //rest result & sign for new subexpresiion
                sign=1;
            }else if(ch==')'){
                result+=sign*num; //add last no inside paranthesis
                num=0;
                if(stack.isEmpty()){ //extra close paranthesis
                    System.out.println("wrong input");
                    return -1;
                }
                result*= stack.pop(); //* with stored sign
                result+=stack.pop();  //add prev result
                
            }
            else if(ch==' '){
                continue;
            }
        }
        result+=sign*num;//any leftover num
        return result;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string to calculate \n write exit to end");
        String input=sc.nextLine();
        
        if(input.equalsIgnoreCase("exit")){
            System.out.println("exiting.....");
            return;
        }
        System.out.println(" output result :"+calculate(input));
    }
}