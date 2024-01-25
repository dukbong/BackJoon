import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	int ly, lx, count;
	int[][] graph;
	boolean[][] visited;
	int[] my = { 1, -1, 0, 0, 1, 1, -1, -1 }, mx = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ly = size[0];
		lx = size[1];

		graph = new int[ly][lx];
		visited = new boolean[ly][lx];

		for (int i = 0; i < ly; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 0; i < ly; i++) {
			for (int j = 0; j < lx; j++) {
				if (graph[i][j] != 0 && !visited[i][j]) {
					visited[i][j] = true;
					bfs(new int[] { i, j });
				}
			}
		}
		System.out.println(count);
	}

	private void bfs(int[] start) {
		boolean top = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);

		while (!q.isEmpty()) {
			int[] n = q.poll();

			for (int i = 0; i < 8; i++) {
				int ny = n[0] + my[i];
				int nx = n[1] + mx[i];

				if (nx >= 0 && nx < lx && ny >= 0 && ny < ly) {
					if (graph[ny][nx] > graph[start[0]][start[1]]) {
						top = false;
					} else if (!visited[ny][nx] && graph[ny][nx] == graph[start[0]][start[1]]) {
						visited[ny][nx] = true;
						q.offer(new int[] { ny, nx });
					}
				}
			}
		}
		if (top) {
			count++;
		}
	}

}