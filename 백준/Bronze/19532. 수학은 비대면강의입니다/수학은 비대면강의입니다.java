import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        loop:
        for(int x = -999; x < 1000; x++){
             for(int y = -999; y < 1000; y++){
                  if(arr[0]*x + arr[1]*y == arr[2] &&
                     arr[3]*x + arr[4]*y == arr[5]){
                      System.out.println(x + " " + y);
                      break loop;
                  }
             }
        }
    }
}