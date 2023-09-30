import java.io.*;
import java.util.*;
import java.util.Map.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        TreeMap<String, String> map = new TreeMap<>(Collections.reverseOrder());
        
        for(int i = 0; i < num; i++) {
        	String[] arr = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);
        	map.put(arr[0], arr[1]);
        }
        
        for(Entry<String, String> entry : map.entrySet()) {
        	if(entry.getValue().equals("enter")) {
        		sb.append(entry.getKey()).append("\n");
        	}
        }
        
        System.out.println(sb.toString());
    }
}