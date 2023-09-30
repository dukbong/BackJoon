import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        TreeMap<String, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < arr[0]+arr[1]; i++) {
        	String str = br.readLine();
        	if(map.get(str) == null) {
        		map.put(str, 0);
        	}else {
        		map.put(str, map.get(str)+1);
        	}
        }
        
        for(Entry<String, Integer> entry : map.entrySet()) {
        	if(entry.getValue() == 1) {
        		count++;
        		sb.append(entry.getKey()).append("\n");
        	}
        }
        
        System.out.println(count);
        System.out.println(sb.toString());
    }
}