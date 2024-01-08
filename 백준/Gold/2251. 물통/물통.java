import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	int maxA, maxB, maxC;
	ArrayList<Integer> list = new ArrayList<>();
	boolean[][][] check;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] bucket = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		maxA = bucket[0];
		maxB = bucket[1];
		maxC = bucket[2];
		check = new boolean[maxA + 1][maxB + 1][maxC + 1];

		bfs();
		StringBuilder sb = new StringBuilder();
		list.stream().forEach(i -> sb.append(i).append(" "));
		System.out.println(sb);
	}

	private void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, maxC });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			if (!check[now[0]][now[1]][now[2]]) {
				
				check[now[0]][now[1]][now[2]] = true;

				if (now[0] == 0) {
					list.add(now[2]);
				}

				if (now[0] + now[1] > maxA) {
					queue.offer(new int[] { maxA, now[0] + now[1] - maxA, now[2] });
				} else {
					queue.offer(new int[] { now[0] + now[1], 0, now[2] });
				}

				if (now[0] + now[1] > maxB) {
					queue.offer(new int[] { now[0] + now[1] - maxB, maxB, now[2] });
				} else {
					queue.add(new int[] { 0, now[0] + now[1], now[2] });
				}

				if (now[0] + now[2] > maxA) { 
					queue.add(new int[] { maxA, now[1], now[0] + now[2] - maxA });
				} else { 
					queue.add(new int[] { now[0] + now[2], now[1], 0 });
				}

				if (now[0] + now[2] > maxC) { 
					queue.add(new int[] { now[0] + now[2] - maxC, now[1], maxC });
				} else { 
					queue.add(new int[] { 0, now[1], now[0] + now[2] });
				}
				
				if (now[1] + now[2] > maxB) {
					queue.add(new int[] { now[0], maxB, now[1] + now[2] - maxB });
				} else { 
					queue.add(new int[] { now[0], now[1] + now[2], 0 });
				}

				if (now[1] + now[2] > maxC) { 
					queue.add(new int[] { now[0], now[1] + now[2] - maxC, maxC });
				} else { 
					queue.add(new int[] { now[0], 0, now[1] + now[2] });
				}
				
			} else {
				continue;
			}
		}
		Collections.sort(list);
	}

}