import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[][][] square;
	static int maxY;
	static int maxX;
	static int maxZ;

	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] squareSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		maxY = squareSize[1];
		maxX = squareSize[0];
		maxZ = squareSize[2];
		
		square = new int[maxZ][maxY][maxX];

		for (int i = 0; i < maxZ; i++) {
			for (int j = 0; j < maxY; j++) {
				square[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
		}

		for (int i = 0; i < maxZ; i++) {
			for (int j = 0; j < maxY; j++) {
				for (int k = 0; k < maxX; k++) {
					if (square[i][j][k] == 1) {
						queue.add(new int[] { i, j, k });
					}
				}
			}
		}
		System.out.println(bfs());
	}

	private int bfs() {

		int max = 1;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nextZ = now[0] + dz[i];
				int nextY = now[1] + dy[i];
				int nextX = now[2] + dx[i];

				if (nextZ >= 0 && nextY >= 0 && nextX >= 0 && nextY < maxY && nextX < maxX && nextZ < maxZ && square[nextZ][nextY][nextX] == 0) {
					queue.add(new int[] {nextZ, nextY, nextX });
					max = square[now[0]][now[1]][now[2]] + 1;
					square[nextZ][nextY][nextX] = max;
				}
			}
		}

		for (int i = 0; i < maxZ; i++) {
			for (int j = 0; j < maxY; j++) {
				for(int k = 0; k < maxX; k++) {
					if (square[i][j][k] == 0) {
						return -1;
					}
				}
			}
		}
		
		return max - 1;

	}
}
