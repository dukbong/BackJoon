import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
	
	// 문재 : 점점 메모리와 시간은 줄지만 50점이다...
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		int qCount = Integer.parseInt(br.readLine());
		// 누적합을 저장하는 Map
		Map<String, int[]> map = new HashMap<>(); 
		
		for (int i = 0; i < qCount; i++) {
			String[] arr = br.readLine().split(" ");
			String key = arr[0];
			int[] mapArr = map.get(key) == null ? new int[N.length()] : map.get(key);
			
			// 저장해둔다.=====================================================================================================
			if (map.isEmpty() || !map.containsKey(key)) { 
				// map에 key값이 존재하지 않는다면 저장한다.
				map.put(key, mapArr); // 여기가 매번 최악의 경우를 생각한다.
//				map.get(key)[0] = N.charAt(0) == key.charAt(0) ? 1 : 0;
				mapArr[0] = oneOrZero(N,key,0);
				for (int j = 1; j < N.length(); j++) {
					mapArr[j] = mapArr[j - 1] + oneOrZero(N,key,j);;
				}
			}
			// 저장해둔다.=====================================================================================================
			
			int check = machine(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), mapArr);
			sb.append(check).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	private int oneOrZero(String str1, String str2, int position){
		return str1.charAt(position) == str2.charAt(0) ? 1 : 0;
	}

	private int machine(int start, int end, int[] sumArr) {
		return sumArr[end] - (start == 0 ? 0 : sumArr[start - 1]);
	}
}