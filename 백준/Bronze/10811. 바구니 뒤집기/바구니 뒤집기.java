import java.io.*;
import java.util.stream.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] total = IntStream.range(1, arr[0] + 1).toArray();
        
        for(int i = 0; i < arr[1]; i++){
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            int start = row[0] - 1;
            int end = row[1] - 1;
            
            int proxyRange = end - start + 1;
            int[] proxy = new int[proxyRange];
            
            for(int p = 0, t = start; p < proxyRange; p++, t++){
            	proxy[p] = total[t];
            }
            
            int len = row[1] - row[0];
            
            for(int k = start, j = len; k <= end; k++, j--){
                 total[k] = proxy[j];
            }
        }
       
        String[] str = Arrays.stream(total).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", str));
    }
}