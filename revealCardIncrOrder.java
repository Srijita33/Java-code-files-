import java.util.*;
public class revealCardIncrOrder
{
    //initial order of card arrengement to reveal in ascending order is printed
    public static int[] revealcard(int[] deck)
    {
        Arrays.sort(deck);
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=deck.length-1;i>=0;i--)
        {
            if(!dq.isEmpty()){
                dq.addFirst(dq.removeLast());
            }
            dq.addFirst(deck[i]);
        }
        int[] result=new int[deck.length];
        int idx=0;
        for(int x:dq) result[idx++]=x;
        return result;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] deck=new int[n];
        for(int i=0;i<n;i++){
            deck[i]=sc.nextInt();
            
        }
        System.out.println(Arrays.toString(revealcard(deck)));
    }
}