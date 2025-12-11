import java.util.*;
public class SortCharByFreq{
    public static String SortCharByfreq(String s)
    {
        if(s==null || s.length()<=1) return s;
        
        Map<Character,Integer> freqmap=new HashMap<>();
        for(char c:s.toCharArray())
        {
            freqmap.put(c,freqmap.getOrDefault(c,0)+1);
        }
        @SuppressWarnings("unchecked")
        List<Character>[] buckets=(List<Character>[]) new List[s.length() +1];
        
        for(char c:freqmap.keySet()){
            int freq=freqmap.get(c);
            if(buckets[freq]==null) buckets[freq]=new ArrayList<>();
            buckets[freq].add(c);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=buckets.length-1; i>=0;i--){
            if(buckets[i]!=null){
                for(char c:buckets[i])
                {
                    for(int j=0;j<i;j++){
                        sb.append(c);
                    }
                }
            }
            
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(SortCharByfreq(str));
    }
}