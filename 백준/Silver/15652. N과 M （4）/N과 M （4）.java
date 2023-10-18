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
//        int[] out = new int[question[1]];
        ArrayList<Integer> out = new ArrayList<>();
        perBackTracking(arr, out, 0, question[1]);
        
        System.out.println(sb.toString());
    }
    
    private void perBackTracking(int[] arr, ArrayList<Integer> out, int depth, int count){
        if(depth == count){
            perSave(out);
            return;
        }
        for(int i = 0; i < arr.length; i++){
        	if (out.size() == 0 || arr[i] >= out.get(out.size() - 1)) {
	            out.add(arr[i]);
	            perBackTracking(arr, out, depth + 1, count);
	            out.remove(out.size() - 1);
        	}
        }
    }
    
    private void perSave(ArrayList<Integer>out){
        for(int i = 0; i < out.size(); i++){
            sb.append(out.get(i)).append(" ");
        }
        sb.append("\n");
    }
}