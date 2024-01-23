import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	int[] graph, dist;
	boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		dist = new int[size];
		visited = new boolean[size];
		graph = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		bfs(0, size - 1);
	}

	private void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()){
			int now = q.poll();
			
			if(now == end){
				System.out.println(dist[now]);
				return;
			}
			
			int max = graph[now];
			
			int next = now;
			
			for(int i = 1; i <= max; i++){
				next = now + i;
				
				if(next <= end && !visited[next]){
					q.offer(next);
					dist[next] = dist[now] + 1;
					visited[next] = true;
				}
				
			}
		}
		System.out.println(-1);
	}

}