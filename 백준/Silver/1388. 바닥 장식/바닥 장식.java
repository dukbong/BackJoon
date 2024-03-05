import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	int[] dx = { 1, -1 };
	int[] dy = { 1, -1 };
	char[][] board;
	boolean[][] visited;
	int N, M;
	int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().solution();
		
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = size[0];
		M = size[1];
		board = new char[N][M];
		visited = new boolean[N][M];

		// 메모리를 줄이기 우해 String -> char
		for (int i = 0; i < N; i++) {
			char[] rows = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = rows[j];
			}
		}

		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) {
					continue;
				}
				bfs(i, j);
			}
		}
		
		System.out.println(count);
	}

	public void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		visited[i][j] = true;

		count++;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int k = 0; k < dx.length; k++) {
				int x;
				int y;
				
				// 이동
				if (board[i][j] == '-') {
					x = cur[0];
					y = cur[1] + dy[k];
				} else {
					x = cur[0] + dx[k];
					y = cur[1];
				}

				if(x >= 0 && y >= 0 && x < N && y < M && !visited[x][y]) {
					if (board[i][j] == board[x][y]) {
						queue.offer(new int[] { x, y });
						visited[x][y] = true;
					}
				}

			}
		}
	}
}