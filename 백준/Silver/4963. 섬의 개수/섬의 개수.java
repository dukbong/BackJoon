import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] moveY = { -1, 1, 0, 0, -1, 1, 1, -1 };
	static int[] moveX = { 0, 0, -1, 1, 1, -1, 1, -1 };
	
	static boolean[][] visited;
	static int[][] graph;
	static int maxY, maxX;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int result = 0;

			int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			// 탈출 조건
			if (size[0] == 0 && size[1] == 0) {
				break;
			}

			// 매번 새롭게 갱신 시켜주자.-------------------
			// --> 헤맨 이유 문제 똑바로..보자.... y x 위치...
			maxY = size[1];
			maxX = size[0];
			graph = new int[maxY][maxX];
			visited = new boolean[maxY][maxX];
			// -------------------------------------

			for (int i = 0; i < maxY; i++) {
				graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			for (int i = 0; i < maxY; i++) {
				for (int j = 0; j < maxX; j++) {
					if (graph[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						bfs(i, j);
						result++;
					}
				}
			}

			sb.append(result).append("\n");

		}

		System.out.println(sb);

	}

	private void bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { y, x });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nextY = now[0] + moveY[i];
				int nextX = now[1] + moveX[i];

				if (nextY >= 0 && nextX >= 0 && nextY < maxY && nextX < maxX) {
					if (graph[nextY][nextX] == 1 && !visited[nextY][nextX]) {
						queue.offer(new int[] { nextY, nextX });
						visited[nextY][nextX] = true;
					}
				}
			}
		}
	}

}
