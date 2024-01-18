import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	int start, end;
	int[] jumpP = new int[2];
	int[] graph;
	boolean[] visited;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		jumpP[0] = question[0];
		jumpP[1] = question[1];
		start = question[2]; // 시작점
		end = question[3]; // 끝점
		visited = new boolean[100001];
		graph = new int[100001];
		visited[start] = true;
		bfs(start);

	}

	private void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()){
			int now = q.poll();
			
			if(now == end){
				System.out.println(graph[end]);
				return;
			}
			
			int[] m = {now - 1, now + 1, now - jumpP[0], now + jumpP[0], now - jumpP[1], now + jumpP[1], now * jumpP[0], now * jumpP[1]};
			
			for(int i = 0; i < 8; i++){
				if(m[i] >= 0 && m[i] < 100001 && !visited[m[i]]){
					visited[m[i]] = true;
					graph[m[i]] = graph[now] + 1; // 이걸로 횟수를 잴꺼다.
					q.offer(m[i]);
				}
			}
		}
	}

}