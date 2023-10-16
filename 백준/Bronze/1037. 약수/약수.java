import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        if(arr.length == 1){
        	System.out.println((long)Math.pow(arr[0], 2));
        }else{
        	Arrays.sort(arr);
        	System.out.println(arr[0] * arr[arr.length-1]);
        }
    }
}