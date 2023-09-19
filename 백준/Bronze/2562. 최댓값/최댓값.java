import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
   public static void main(String[] args) throws IOException{
      new Main().solution();
   }
   
   private void solution() throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
      int max = 0;
      int maxIndex = 0;
      for(int i = 0; i < 9; i++){
         int num = Integer.parseInt(br.readLine());
        
         if (max < num){
            max = num;
            maxIndex = i+1;
         }
      }
     
      System.out.println(max);
      System.out.println(maxIndex);
   }
}