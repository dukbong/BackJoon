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
	int[] mY = { -1, 1, 0, 0 }, mX = { 0, 0, -1, 1 };

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

		// 빈 공간을 '.'(점)으로 나타내고 울타리를 '#', 늑대를 'v', 양을 'k
		for (int i = 0; i < ly; i++) {
			graph[i] = br.readLine().toCharArray();
		}

		int sheep = 0;
		int wolf = 0;

		for (int i = 0; i < ly; i++) {
			for (int j = 0; j < lx; j++) {
				if (graph[i][j] != '#' && !visited[i][j]) {
					int[] animal = bfs(new int[] { i, j });
					sheep += animal[0];
					wolf += animal[1];
				}
			}
		}
		System.out.println(sheep + " " + wolf);
	}

	private int[] bfs(int[] start) {
		int sheepArea = 0;
		int wolfArea = 0;

		Queue<int[]> q = new LinkedList<>();
		q.offer(start);

		if (graph[start[0]][start[1]] == 'v') {
			wolfArea++;
		} else if (graph[start[0]][start[1]] == 'k') {
			sheepArea++;
		}

		visited[start[0]][start[1]] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now[0] + mY[i];
				int nx = now[1] + mX[i];

				if (ny >= 0 && nx >= 0 && ny < ly && nx < lx) {
					if (graph[ny][nx] != '#' && !visited[ny][nx]) {
						visited[ny][nx] = true;
						q.offer(new int[] { ny, nx });
						
						if (graph[ny][nx] == 'v') {
							wolfArea++;
						} else if (graph[ny][nx] == 'k') {
							sheepArea++;
						}
						
					}
				}
			}
		}
		if (wolfArea == 0 && sheepArea == 0) {
			return new int[] { 0, 0 };
		}

		if (wolfArea >= sheepArea) {
			sheepArea = 0;
		} else {
			wolfArea = 0;
		}
		
		return new int[] { sheepArea, wolfArea };
	}

}
