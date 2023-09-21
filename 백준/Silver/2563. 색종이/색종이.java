import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        int[][] total = new int[101][101];
        
        for(int i = 0; i < num; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = arr[1]; j < arr[1]+10; j++){
                for(int k = arr[0]; k < arr[0]+10; k++){
                    if(total[j][k] == 0){
                         total[j][k] = 1;
                    }
                }
            }
        }
        int result = Arrays.stream(total).flatMapToInt(Arrays::stream).sum();
        System.out.println(result);
    }
}