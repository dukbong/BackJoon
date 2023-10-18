import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws IOException {
        new Main().solution();
    }
    
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[] arr = IntStream.rangeClosed(1, question[0]).toArray();
        boolean[] bool = new boolean[question[0]];
        
        ComboBackTracking(arr, bool, 0, question[1]);
        
        System.out.println(sb.toString());
    }
    
    private void ComboBackTracking(int[] arr, boolean[] bool, int start, int count){
        if(count == 0){
            ComboShow(arr, bool);
            return;
        }
        for(int i = start; i < arr.length; i++){
            bool[i] = true;
            ComboBackTracking(arr, bool, i + 1, count - 1);
            bool[i] = false;
        }
    }
    
    private void ComboShow(int[] arr, boolean[] bool){
    	for(int i = 0; i < arr.length; i++){
    		if(bool[i]){
    			sb.append(arr[i]).append(" ");
    		}
    	}
    	sb.append("\n");
    }
}