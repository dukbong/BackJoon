import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int t;

	static int maxY, maxX;
	static String[][] graph;
	static boolean[][] visitedC;
	static boolean[][] visitedS;

	static int[] moveY = { -1, 1, 0, 0 };
	static int[] moveX = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maxY = Integer.parseInt(br.readLine());
		int commonColor = 0;
		int specialColor = 0;

		// graph Size and Value fixed
		graph = new String[maxY][];

		for (int i = 0; i < maxY; i++) {
			graph[i] = br.readLine().split("");
		}
		maxX = graph[0].length;

		visitedC = new boolean[maxY][maxX];
		visitedS = new boolean[maxY][maxX];

		for (t = 0; t < 2; t++) {
			for (int i = 0; i < maxY; i++) {
				for (int j = 0; j < maxX; j++) {
					if (t == 0) {
						if (!visitedC[i][j]) {
							bfs(i, j, visitedC);
							commonColor++;
						}
					} else {
						if (!visitedS[i][j]) {
							bfs(i, j, visitedS);
							specialColor++;
						}
					}
				}
			}
		}
		System.out.println(commonColor + " " + specialColor);
	}

	private void bfs(int y, int x, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { y, x });
		visitedC[y][x] = true;
		
		// 적록색명
		if (t == 1) {
			for(int i = 0; i < maxY; i++){
				for(int j = 0; j < maxX; j++){
					if(graph[i][j].equals("G")){
						graph[i][j] = "R";
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			String nowColor = graph[now[0]][now[1]];
			for (int i = 0; i < 4; i++) {
				int nextY = now[0] + moveY[i];
				int nextX = now[1] + moveX[i];

				if (nextY >= 0 && nextY < maxY && nextX >= 0 && nextX < maxX) {
					if (!visited[nextY][nextX]) {
						if (nowColor.equals(graph[nextY][nextX])) {
							queue.offer(new int[] { nextY, nextX });
							visited[nextY][nextX] = true;
						}

					}
				}
			}
		}
	}
}

/*
 * 
 * RRRBB GGBBB BBBRR BBRRR RRRRR
 * 
 */