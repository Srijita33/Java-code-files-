import java.util.*;
public class QueueUseStack{
    Stack<Integer> stackin=new Stack<>();
    Stack<Integer> stackout=new Stack<>();
    
    public void push(int val)
    {
        stackin.push(val);
    }
    public int pop()
    {
       if(stackout.isEmpty())
       {
           while(!stackin.isEmpty())
           {
               stackout.push(stackin.pop());
           }
       }
       if(stackout.isEmpty()){
           throw new RuntimeException("queue empty");
       }
       return stackout.pop();
    }
    public int peek(){
        if(stackout.isEmpty())
       {
           while(!stackin.isEmpty())
           {
               stackout.push(stackin.pop());
           }
       }
       if(stackout.isEmpty()){
           throw new RuntimeException("queue empty");
       }
       return stackout.peek();
    }
    public boolean empty(){
        return (stackin.isEmpty() && stackout.isEmpty());
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        QueueUseStack q=new QueueUseStack();
        
        System.out.println("1->push\n2->pop\n3->peek\n4->empty\n5->exit");
        while(true){
            System.out.println("enter choice");
            int choice=sc.nextInt();
            switch(choice){
                case 1: int val=sc.nextInt();
                        q.push(val);
                        break;
                case 2: try{
                            System.out.println("pop :"+q.pop());
                        }
                        catch(RuntimeException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 3: try{
                            System.out.println("peek  :"+q.peek());
                        }
                        catch(RuntimeException e){
                            System.out.println(e.getMessage());
                        }
                        break;
                case 4: System.out.println("if queues are empty?"+ q.empty());
                        break;
                case 5: System.out.println("exiting----");
                        return;
                default:System.out.println("wrong choice");
                
            }
        }
        
    }
}