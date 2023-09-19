import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
    
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int total = ((arr[0] == 0)? 24 * 60 : arr[0] * 60) + arr[1];
        int result = total + Integer.parseInt(br.readLine());
        
        int hour = result / 60;
        if(hour >= 24) hour = hour - 24;
        int min  = result % 60;
        
        System.out.println(hour + " " + min);
    }
}