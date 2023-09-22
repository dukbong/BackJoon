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
    	int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = (arr[2] - arr[1]) / (arr[0] - arr[1]);
        int b = (arr[2] - arr[1]) % (arr[0] - arr[1]);
        if(b != 0) a++;
    	System.out.println(a);
    }
}