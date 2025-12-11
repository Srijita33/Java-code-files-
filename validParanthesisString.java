import java.util.*;
public class validParanthesisString{
    public static boolean isValidString(String s){
        int low=0, high=0;
        for(char ch:s.toCharArray()){
            if( ch=='('){
                high++;
                low++;
            }
            else if( ch==')'){
                high--;
                low--;
            }
            else{
                high++;
                low--;
            }
            if(high<0)return false;
            if(low<0) low=0;
        }
        return low==0;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("ENter string with (),*");
        String input=sc.nextLine();
        boolean res=isValidString(input);
        if(res) System.out.println(input + "valid");
        else System.out.println(input+" not valid");
    }
}