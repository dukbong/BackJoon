import java.util.*;
import java.io.*;

public class Main {

	static int[] resultArr = new int[100001];
	static int[] move = { -1, 1, 2 };
	static int min;
	static int max;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] len = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		min = len[0];
		max = len[1];

		if (min == max) {
			System.out.println(0);
		} else {
			bfs(min);
		}

	}

	private void bfs(int start) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		resultArr[start] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < 3; i++) {
				int next = 0;

				if (i == 2) {
					next = now * move[i];
				} else {
					next = now + move[i];
				}

				if (next == max) {
					System.out.println(resultArr[now]);
					return;
				}

				if (next >= 0 && next < resultArr.length && resultArr[next] == 0) {
					queue.add(next);
					resultArr[next] = resultArr[now] + 1;
				}
			}
		}

	}

}
