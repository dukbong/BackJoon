import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	int limit;
	int[][] graph;
	int[][] dist;
	int[] moveY = { -1, 1, 0, 0 }, moveX = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		limit = Integer.parseInt(br.readLine());
		dist = new int[limit][limit];
		graph = new int[limit][limit];
		Arrays.stream(dist).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
		dist[0][0] = 0;
		for (int i = 0; i < limit; i++)
			graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		System.out.println(dfs(new int[] { 0, 0 }));

	}

	private int dfs(int[] start) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = now[0] + moveY[i];
				int nextX = now[1] + moveX[i];
				if (nextY >= 0 && nextX >= 0 && nextY < limit && nextX < limit) {
					if (dist[nextY][nextX] > dist[now[0]][now[1]]) {
						dist[nextY][nextX] = dist[now[0]][now[1]] + (graph[nextY][nextX] == 1 ? 0 : 1);
						queue.offer(new int[] { nextY, nextX });
					}
				}
			}
		}
		return dist[limit - 1][limit - 1];
	}
}
