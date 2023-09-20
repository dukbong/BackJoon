import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            int num = Integer.parseInt(br.readLine()) % 42;
            arr[i] = num;
        }
        
        long total = Arrays.stream(arr)
                          .distinct()
                          .count();
        System.out.println(total);
    }
}