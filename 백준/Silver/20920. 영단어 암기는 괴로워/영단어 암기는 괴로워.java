import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Map<String, Integer> map = new TreeMap<>(); // key를 기준으로 정렬한다.
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n[0]; i++){ // N
			String str = br.readLine();
			if(str.length() >= n[1]){
				map.put(str, map.getOrDefault(str, 0) + 1); // logN
			}
		}
		// 1차 시간 초과 (N logN)
		// 3 2 1순으로 지정해주면 될꺼 같다.
		// 1. TreeMap으로  key를 사전순으로 만들었다.
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet()); // N
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() { // N logN

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) { 
				return o2.getKey().length() - o1.getKey().length();
			}
			
		});
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() { // N logN

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
			
		});
		list.stream().map(i -> i.getKey()).forEach(i -> sb.append(i).append("\n")); // N
		System.out.println(sb.toString());
	}
}