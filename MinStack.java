import java.util.Scanner;
import java.util.Stack;

public class MinStack{
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack(){
        stack= new Stack<>();
        minStack=new Stack<>();    
    }
    public void push(int val){
        stack.push(val);
        if(minStack.isEmpty() || val<minStack.peek()){
            minStack.push(val);
        }
    }
    public void pop(){
        if(!stack.isEmpty()){
            if(stack.peek().equals(minStack.peek()))
            {
                minStack.pop();
            }
            stack.pop();
        }
        else{
            System.out.println("stack empty nothing to pop");
        }
        
    }
    public int top(){
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return -1;
    }
    public int minimum(){
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        MinStack mystack= new MinStack();
        //new object of MinStcack class
        System.out.println("enter the no of operation");
        int n=sc.nextInt();
        System.out.println("1->push\n2->pop\n3-->top\n4->min element\n");
        for (int i=0;i<n;i++){
            
            int choice= sc.nextInt();
            switch(choice){
                case 1: System.out.println("enter element to push");
                        int val=sc.nextInt();
                        mystack.push(val);
                        break;
                case 2: mystack.pop();
                        break;
                case 3: int top=mystack.top();
                        System.out.println("top element "+top);
                        break;
                case 4: System.out.println("Current minimum element of stack :"+ mystack.minimum());
                        break;
                default:System.out.println("wrong choice");
            }
        }
        
        sc.close();
    }
}