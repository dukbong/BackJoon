import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	int[] dist;
	boolean[] visited;
	int[] oper = { 3, 2, 1 };

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int start = Integer.parseInt(br.readLine());
		dist = new int[start + 1];
		visited = new boolean[start + 1];
		visited[start] = true;
		bfs(start);
		
		int[] line = new int[dist[1] + 1]; // start 포함 해야하니깐
		int num = 1;
		line[dist[1]] = 1;
		for (int i = dist[1] - 1; i >= 0; i--) {
			if (num * 3 <= start && dist[num * 3] == dist[num] - 1)
				num *= 3;
			else if (num * 2 <= start && dist[num * 2] == dist[num] - 1)
				num *= 2;
			else
				num += 1;
			line[i] = num;
		}
		StringBuilder sb = new StringBuilder();
		Arrays.stream(line).forEach(i -> sb.append(i).append(" "));
		System.out.println(sb.toString());
	}

	private void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);

		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == 1) {
				System.out.println(dist[1]);
				return;
			}

			int next = now;

			for (int i = 0; i < 3; i++) {
				switch (i) {
				case 0:
					if (now % 3 == 0)
						next = now / 3;
					break;
				case 1:
					if (now % 2 == 0)
						next = now / 2;
					break;
				case 2:
					next = now - 1;
					break;
				}

				if (!visited[next] && now > 0) {
					visited[next] = true;
					dist[next] = dist[now] + 1;
					q.offer(next);
				}
			}
		}
		System.out.println(-1);
	}

}