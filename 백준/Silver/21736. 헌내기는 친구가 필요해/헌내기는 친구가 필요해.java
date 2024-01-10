import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	int ly, lx;
	char[][] graph;
	boolean[][] visited;
	int[] my = { -1, 1, 0, 0 }, mx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ly = size[0];
		lx = size[1];

		graph = new char[ly][lx];
		visited = new boolean[ly][lx];
		int iy = 0;
		int ix = 0;
		int result = 0;

		for (int i = 0; i < ly; i++) {
			String rowText = br.readLine();
			graph[i] = rowText.toCharArray();

			if (rowText.contains("I")) {
				iy = i;
				ix = rowText.indexOf("I");
			}
		}

		visited[iy][ix] = true;
		result = bfs(new int[] { iy, ix });

		if (result == 0) {
			System.out.println("TT");
		} else {
			System.out.println(result);
		}

	}

	private int bfs(int[] start) {
		int result = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);

		while (!q.isEmpty()) {
			int[] n = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = n[0] + my[i];
				int nx = n[1] + mx[i];

				if (nx >= 0 && ny >= 0 && nx < lx && ny < ly) {
					if (!visited[ny][nx] && graph[ny][nx] != 'X') {
						visited[ny][nx] = true;
						q.offer(new int[] { ny, nx });
						if (graph[ny][nx] == 'P') {
							result++;
						}
					}
				}
			}
		}

		return result;
	}
}
