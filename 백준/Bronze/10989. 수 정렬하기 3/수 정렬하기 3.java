import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        
        int[] arr = new int[num];
        
        for(int i = 0; i < num; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        	
        Arrays.sort(arr);
        
        for(int i : arr) {
        	sb.append(i).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}