import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[] arr = new int[4];
        arr[0]= n[0];
        arr[1] = n[1];
        arr[2] = n[2] - n[0];
        arr[3] = n[3] - n[1]; 
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}