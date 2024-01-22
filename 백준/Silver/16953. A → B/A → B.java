import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

//	int[] graph;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//		graph = new int[question[1] + 1];

		bfs(question[0], question[1]);
	}

	private void bfs(long start, long end) {
		Queue<Long> q = new LinkedList<>();
		q.offer(start);
//		메모리 초과
//		while (!q.isEmpty()) {
//			int now = q.poll();
//
//			if (now == end) {
//				System.out.println(graph[end] + 1);
//				return;
//			}
//
//			int next = now;
//
//			for (int i = 0; i < 2; i++) {
//				if (i == 0) {
//					next = now * 2;
//				} else if (i == 1) {
//					next = now * 10 + 1;
//				}
//
//				if (next <= end) {
//					q.offer(next);
//					graph[next] = graph[now] + 1;
//				}
//
//			}
//		}
	
		int count = 0;
		while(!q.isEmpty()){
			int qSize = q.size();
			
			for(int i = 0; i < qSize; i++){
				long now = q.poll();
				
				if(now == end){
					System.out.println(count + 1);
					return;
				}
				
				if(now * 2 <= end){
					q.offer(now * 2);
				}
				
				if(now * 10 + 1 <= end){
					q.offer(now * 10 + 1);
				}
			}
			
			count++;
		}
		System.out.println(-1);
	}
}