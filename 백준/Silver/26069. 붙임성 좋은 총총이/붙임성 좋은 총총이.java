import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
        	String[] arr = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);
        	for(int j = 0; j < arr.length; j++){
        		if(set.contains(arr[j])){
        			Arrays.stream(arr).forEach(x -> set.add(x));;
        			break;
        		}
        	}
        }
        System.out.println(set.size());
    }
}