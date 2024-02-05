import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().solution();
	}

	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCount = Integer.parseInt(br.readLine());
		
		while(testCount-- > 0) {
			int testC = Integer.parseInt(br.readLine());
			
			Map<String, Integer> map = new HashMap<>(); // 저장 공간
			int count = 1;
			
			while(testC-- > 0) {
				String[] arr = br.readLine().split(" ");
				
				if(map.get(arr[1]) != null) {
					map.put(arr[1], map.get(arr[1]) + 1);
				}else {
					map.put(arr[1], 1);
				}
			}
			
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				count *= (entry.getValue() + 1);
			}
			sb.append(count - 1).append("\n");
		}
		
		System.out.println(sb);
		
	}

}
