import java.util.*;
public class stackUsingQueue{
    Queue<Integer> q1= new LinkedList<>();
    Queue<Integer> q2= new LinkedList<>();
    
    public void push(int val){
        if(q1.isEmpty()){
            q1.add(val);
        }else{
            while(!q1.isEmpty()){
                q2.add(q1.poll());
            }
            q1.add(val);
            while(!q2.isEmpty()){
                q1.add(q2.poll());
            }
        }
    }
    public int pop(){
        if(q1.isEmpty()) {
            System.out.println("queue empty");
            return -1;
        }
        return(q1.poll());
    }
    public int peek(){
        if(q1.isEmpty()) {
            System.out.println("queue empty");
            return -1;
        }
        return(q1.peek());
    }
    public boolean empty(){
        return q1.isEmpty();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        stackUsingQueue st = new stackUsingQueue();
        
        System.out.println("1->push\n2->pop\n3->peek\n4->empty\n5->exit");
        while(true){
            System.out.println("enter choice");
            int choice=sc.nextInt();
            switch(choice){
                case 1: int val=sc.nextInt();
                        st.push(val);
                        break;
                case 2: System.out.println("popped element"+ st.pop());
                        break;
                case 3: System.out.println("top element"+ st.peek());
                        break;
                case 4: System.out.println("if stack is empty?"+ st.empty());
                        break;
                case 5: System.out.println("exiting----");
                        return;
                default:System.out.println("wrong choice");
                
            }
        }
    }
}