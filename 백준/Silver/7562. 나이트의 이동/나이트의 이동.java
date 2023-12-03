import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dy = { 2, 1, 2, 1, -2, -1, -2, -1 };
	static int[] dx = { 1, 2, -1, -2, 1, 2, -1, -2 };
	static int[][] square;
	static int[] end;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 총 테스트 수
		int qCount = Integer.parseInt(br.readLine());

		for (int i = 0; i < qCount; i++) {
			// 체스판 크기
			int squareSize = Integer.parseInt(br.readLine());
			square = new int[squareSize][squareSize];

			// 시작 위치
			int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			// 끝 위치
			end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			if(start[0] == end[0] && start[1] == end[1]) {
				sb.append(0).append("\n");
			}else {
				// 탐색
				bfs(start);
			}
		}

		System.out.println(sb);
	}

	private void bfs(int[] start) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nextY = now[0] + dy[i];
				int nextX = now[1] + dx[i];

				if (nextY >= 0 && nextX >= 0 && nextY < square.length && nextX < square.length
						&& square[nextY][nextX] == 0) {
					queue.add(new int[] { nextY, nextX });
					square[nextY][nextX] = square[now[0]][now[1]] + 1;
					if (nextY == end[0] && nextX == end[1]) {
						sb.append(square[nextY][nextX]).append("\n");
						return;
					}
				}
			}
		}

	}
}
