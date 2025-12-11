import java.util.*;
public class removeToMakeValidPar{
    public static String removeToMakeVP(String s){
        StringBuilder result=new StringBuilder();
        int balance=0;
        
        //1st pass to remove )
        for(char ch:s.toCharArray()){
            if(ch=='('){
                balance++;
                result.append(ch);
            }
            else if(ch==')'){
                if(balance ==0) continue;
                balance--;
                result.append(ch);
            }
            else{
                result.append(ch);
            }
        }
        StringBuilder finalrev=new StringBuilder();
        //2nd pass to remove (
        for(int i=result.length()-1;i>=0;i--){
            char cc=result.charAt(i);
            if(cc=='(' && balance>0){
                balance--;
                continue;
            }
            finalrev.append(cc);
        }
        return finalrev.reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        String input=sc.nextLine();
        
        System.out.println("output with valid paranthesis  " + removeToMakeVP(input));
        
    }
}