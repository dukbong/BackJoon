import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
        	int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	Arrays.sort(arr);
        	for(int j = 1; j <= arr[0]; j++) {
        		if(arr[0] % j == 0 && arr[1] % j == 0) {
        			int x = arr[0] / j;
        			int y = arr[1] / j;
        			int z = x * y * j;
        			
        			if(map.get(i) != null) {
        				int preZ = map.get(i);
        				int newZ = z;
        				if(newZ < preZ) {
        					map.put(i, newZ);
        				}
        			}else {
        				map.put(i, z);
        			}
        		}
        	}
        }
        
        for(Entry<Integer, Integer> entry : map.entrySet()) {
        	System.out.println(entry.getValue());
        }
    }
}