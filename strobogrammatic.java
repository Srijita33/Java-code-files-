import java.util.* ;
import java.io.*; 
public class Solution {
   
   	public static boolean isStrobogrammatic(String n){
    	// Write your code here.
		HashMap<Character,Character> map=new HashMap<>();
		map.put('0','0');
		map.put('1','1');
		map.put('8','8');
		map.put('6','9');
		map.put('9','6');
		int i=0;
		int j=n.length()-1;
		while(i<=j){
			char a=n.charAt(i);
			char b=n.charAt(j);
			if(!map.containsKey(a)||map.get(a)!=b){
				return false;
			}
			i++;
			j--;
		}
		return true;
    }

}
