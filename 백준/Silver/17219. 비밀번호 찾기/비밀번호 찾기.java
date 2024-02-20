import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Map<String, String> map = new HashMap<>();
		
		while(arr[0]-->0) {
			String[] idAndPwd = br.readLine().split(" ");
			map.put(idAndPwd[0], idAndPwd[1]);
		}
		
		while(arr[1]-->0) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}

}