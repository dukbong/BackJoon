import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 연산의 개수
		
		PriorityQueue<Map<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map<Integer, Integer>>() {

			@Override
			public int compare(Map<Integer, Integer> o1, Map<Integer, Integer> o2) {
				
				/* key에는 절대값을 value에는 실제값을 넣는다.
				 * 
				 * - 만약 key가 동일하다면 value를 기준으로 정렬한다.
				 * */
				
				int o1Key = o1.keySet().iterator().hasNext()?o1.keySet().iterator().next():0;
				int o2Key = o2.keySet().iterator().hasNext()?o2.keySet().iterator().next():0;
				
				if(o1Key == o2Key){ // 음수가 있을 수 도 있다. 
					return o1.get(o1Key) - o2.get(o2Key);
//					return Integer.compare(o1.get(o1Key), o2.get(o2Key));
				}
				// 양수
				return o1Key - o2Key;
				
			}
			
		});
		
		Map<Integer, Integer> map = null;
		
		for(int i = 0; i < n; i++){
			int x = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			
			if(x == 0){
				if(queue.isEmpty()){
					sb.append("0").append("\n");
				}else{
					Map<Integer, Integer> test = queue.poll();
					int key = test.keySet().iterator().next();
					
					sb.append(test.get(key)).append("\n");
				}
			}else{
				map.put(Math.abs(x), x);
				queue.offer(map);
			}
		}
		
		System.out.println(sb);
	}
}

