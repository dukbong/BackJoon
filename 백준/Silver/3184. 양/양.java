import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	int maxY, maxX;
	char[][] yard;
	boolean[][] visited;
	int[] mY = { -1, 1, 0, 0 }, mX = { 0, 0, -1, 1 };

	int totalSheep = 0;
	int totalWolf = 0;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		maxY = size[0];
		maxX = size[1];

		yard = new char[maxY][maxX];
		visited = new boolean[maxY][maxX];

		for (int i = 0; i < maxY; i++) {
			yard[i] = br.readLine().replace(" ", "").toCharArray();
		}

		for (int i = 0; i < maxY; i++) {
			for (int j = 0; j < maxX; j++) {
				if (yard[i][j] != '#' && !visited[i][j]) {
					visited[i][j] = true;
					bfs(new int[] { i, j });
				}
			}
		}

		System.out.println(totalSheep + " " + totalWolf);

	}

	private void bfs(int[] start) {
		int sheep = 0;
		int wolf = 0;

		Queue<int[]> q = new LinkedList<>();
		q.offer(start);

		while (!q.isEmpty()) {
			int[] now = q.poll();

			char whoAreYou = yard[now[0]][now[1]];
			if (whoAreYou == 'o') {
				sheep++;
			} else if (whoAreYou == 'v') {
				wolf++;
			}

			for (int i = 0; i < 4; i++) {
				int nextY = now[0] + mY[i];
				int nextX = now[1] + mX[i];

				if (nextY >= 0 && nextX >= 0 && nextY < maxY && nextX < maxX) {
					if (yard[nextY][nextX] != '#' && !visited[nextY][nextX]) {
						q.offer(new int[] { nextY, nextX });
						visited[nextY][nextX] = true;
					}
				}
			}
		}

		if (sheep > wolf) {
			totalSheep += sheep;
		} else {
			totalWolf += wolf;
		}
	}

}