
public class findGcd{
    static int findGcd(int a,int b){
        if(b==0){
            return a;
        }
        else{
            return findGcd(b,a%b);
        }
    }
    static int findArrayGcd(int[] arr){
        int result=arr[0];
        for(int i=0;i<arr.length;i++){
            result=findGcd(result,arr[i]);
            if (result==1){
                return 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        int[] arr={12,24,17};
        int gcd=findArrayGcd(arr);
        System.out.println("the gcd of array is :"+gcd);
        
    }
}