import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 연산의 개수
		
		// 우선 순위 큐 >> 무조건 first in first out이 아니라 정렬을 정의해서 우선 순위를 지정해줄 수 있으면 우선순위가 높은거 부터 나간다.
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		});
		
		for(int i = 0; i < n; i++){
			int x = Integer.parseInt(br.readLine());
			if(x > 0){ 
				queue.offer(x);
			}else{
				if(queue.size() == 0){
					sb.append(0).append("\n");
				}else{
					sb.append(queue.poll()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}

