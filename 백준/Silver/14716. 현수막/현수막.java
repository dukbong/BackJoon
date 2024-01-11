import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Main {
	
	int ly, lx;
	int[][] graph;
	boolean[][] visited;
	int[] my = { 1, 1, 1, 0, 0, -1, -1, -1 }, mx = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ly = size[0];
		lx = size[1];

		graph = new int[ly][lx];
		visited = new boolean[ly][lx];
//		int result = 0;

		for (int i = 0; i < ly; i++) {
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
//		for(int i = 0; i < ly; i++){
//			for(int j = 0; j < lx; j++){
//				if(graph[i][j] == 1 && !visited[i][j]){
//					bfs(new int[] {i ,j});
//					result++;
//				}
//			}
//		}
//		System.out.println(result);
		
		// stream을 이용해서 만들어보기
		System.out.println(IntStream.range(0,  ly).flatMap(i -> IntStream.range(0, lx).filter(j -> graph[i][j] == 1 && !visited[i][j]).peek(k -> bfs(new int[]{i, k}))).count());
		

	}

	private void bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);

		while (!q.isEmpty()) {
			int[] n = q.poll();

			for (int i = 0; i < 8; i++) {
				int ny = n[0] + my[i];
				int nx = n[1] + mx[i];

				if (nx >= 0 && ny >= 0 && nx < lx && ny < ly) {
					if (!visited[ny][nx] && graph[ny][nx] == 1) {
						visited[ny][nx] = true;
						q.offer(new int[] { ny, nx });
					}
				}
			}
		}
	}
}
