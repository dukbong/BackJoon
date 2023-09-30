import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        
        for(int i = 0; i < num[0]; i++) {
        	String str = br.readLine();
        	map.put(str, i+1);
        }
        ArrayList<String> list = new ArrayList<>(map.keySet());
        
        for(int i = 0; i < num[1]; i++) {
        	String str = br.readLine();
        	if(map.get(str) != null) {
        		sb.append(map.get(str)).append("\n");
        	}else {
        		String name = list.get(Integer.parseInt(str) - 1);
        		
        		sb.append(name).append("\n");
        	}
        }
        System.out.println(sb.toString());
    }
}