
import java.util.Scanner;
public class Hourglass{
    static int row=4;
    static int col=4;
    static int findMaxHourglass(int[][] mat){
      if(row<3||col<3){
          System.out.println("not possible");
          System.exit(0);
      }
      int maxsum=Integer.MIN_VALUE;
      int sum=0;
      for(int i=0;i<row-2;i++){
          for(int j=0;j<col-2;j++){
             sum= mat[i][j]+mat[i][j+1]+mat[i][j+2]+
                     mat[i+1][j+1]+
                     mat[i+2][j]+mat[i+2][j+1]+mat[i+2][j+2];
             maxsum=Math.max(sum,maxsum);
                     
          }
      }
      return maxsum;
      
    }
    public static void main(String[] args){
        int[][] matrix={{1,2,3,4},
                        {3,4,5,6},
                        {4,5,6,7},
                        {7,8,9,1}};
        int maxsum=findMaxHourglass(matrix);
        System.out.println("max hourglass sum :"+maxsum);
                        
    }
}