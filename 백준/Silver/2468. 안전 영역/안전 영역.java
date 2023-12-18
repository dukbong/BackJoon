import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int max = 0;

	static int maxY, maxX;
	static int[][] graph;
	static boolean[][] visited;
	static int[] moveY = { -1, 1, 0, 0 };
	static int[] moveX = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maxY = Integer.parseInt(br.readLine());
		graph = new int[maxY][];

		for (int i = 0; i < maxY; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		maxX = graph[0].length;
		visited = new boolean[maxY][maxX];

		// 여기서 하나씩 잠기게 만들면서 bfs를 진행하여 진행횟수가 최대인것을 확인하면 된다.
		for (int t = 0; t <= 100; t++) {

			rainArea(t);

			boolean[][] tempArea = new boolean[maxY][maxX];

			for (int i = 0; i < maxY; i++) {
				tempArea[i] = visited[i].clone();
			}

			for (int i = 0; i < maxY; i++) {
				for (int j = 0; j < maxX; j++) {
					if (!tempArea[i][j]) {
						bfs(i, j, tempArea);
						result++;
					}
				}
			}

			if (result == 0) {
				break;
			}

			// System.out.println("t = " + t + ", result = " + result);
			max = Integer.max(result, max);
			result = 0;
		}

		System.out.println(max);
	}

	private void rainArea(int t) {

		for (int i = 0; i < maxY; i++) {
			for (int j = 0; j < maxX; j++) {
				if (graph[i][j] <= t) {
					visited[i][j] = true;
				}
			}
		}

	}

	private void bfs(int y, int x, boolean[][] tempArea) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { y, x });
		tempArea[y][x] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextY = now[0] + moveY[i];
				int nextX = now[1] + moveX[i];

				if (nextY >= 0 && nextX >= 0) {
					if (nextY < maxY && nextX < maxX) {
						if (!tempArea[nextY][nextX]) {
							queue.offer(new int[] { nextY, nextX });
							tempArea[nextY][nextX] = true;
						}
					}
				}
			}
		}
	}
}

/*
 * 
 * 5 6 8 2 6 2 3 2 3 4 6 6 7 3 3 2 7 2 5 3 6 8 9 5 2 7
 * 
 * 5
 * 
 */