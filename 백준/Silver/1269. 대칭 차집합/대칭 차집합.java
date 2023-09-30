import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] notUse = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < arr1.length; i++) {
        	map.put(arr1[i], 0);
        }
        for(int i = 0; i < arr2.length; i++) {
        	if(map.get(arr2[i]) == null) {
        		map.put(arr2[i], 0);
        	}else {
        		map.put(arr2[i], map.get(arr2[i]) + 1);
        	}
        }
        int count = 0;
        for(Entry<Integer, Integer> entry : map.entrySet()) {
        	if(entry.getValue() == 0) {
        		count ++;
        	}
        }
        System.out.println(count);
    }
}