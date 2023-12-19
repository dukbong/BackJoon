import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

	static String[][] graph;
	static int maxY, maxX;
	static int[] moveY = { -1, 1, 0, 0 };
	static int[] moveX = { 0, 0, -1, 1 };
	// 배열에는 대문자 알파벳만 올수 있따.
	static boolean[] alphabet = new boolean[26];

	static int result = 0;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		maxY = size[0];
		maxX = size[1];

		graph = new String[maxY][maxX];

		for (int i = 0; i < maxY; i++) {
			String[] elem = br.readLine().split("");
			graph[i] = elem;
		}
		dfs(0, 0, 0);
		System.out.println(result == 0 ? 1 : result);
	}

	private void dfs(int y, int x, int count) {
		if (alphabet[graph[y][x].charAt(0) - 'A']) {
			result = Integer.max(result, count);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextY = y + moveY[i];
			int nextX = x + moveX[i];

			if (nextY >= 0 && nextY < maxY && nextX >= 0 && nextX < maxX) {
				if (!alphabet[graph[y][x].charAt(0) - 'A']) {
					alphabet[graph[y][x].charAt(0) - 'A'] = true;
					dfs(nextY, nextX, count + 1);
					// count++을 해서 count 자체가 바뀌어서 틀리고 있었다..
					alphabet[graph[y][x].charAt(0) - 'A'] = false;
				}
			}
		}

	}

	// bfs로는 안될꺼 같음
	// private void bfs(int y, int x) {
	// Queue<int[]> queue = new LinkedList<>();
	// queue.offer(new int[] { y, x });
	// set.add(graph[y][x]);
	//
	// while (!queue.isEmpty()) {
	// int[] now = queue.poll();
	//
	// for (int i = 0; i < 4; i++) {
	//
	// int nextY = now[0] + moveY[i];
	// int nextX = now[1] + moveX[i];
	//
	// if (nextY >= 0 && nextY < maxY && nextX >= 0 && nextX < maxX) {
	//
	// if (!visited[nextY][nextX]) {
	// queue.add(new int[] { nextY, nextX });
	// visited[nextY][nextX] = true;
	// set.add(graph[nextY][nextX]);
	// resultGraph[nextY][nextX] = resultGraph[now[0]][now[1]] + 1;
	// }
	//
	// }
	// }
	// }
	// }
}