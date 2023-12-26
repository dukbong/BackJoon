import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int maxY, maxX;
	static int[][] graph;
	static boolean[][] visited;
	static int[][] graph2;
	static int[] moveY = {-1, 1, 0, 0}, moveX = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arrSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		maxY = arrSize[0];
		maxX = arrSize[1];
		
		graph = new int[maxY][maxX];
		visited = new boolean[maxY][maxX];
		graph2 = new int[maxY][maxX];
		
		for(int i = 0; i < maxY; i++){
			int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			graph[i] = row;
		}
		
		for(int i = 0; i < maxY; i++){
			for(int j = 0; j < maxX; j++){
				if(graph[i][j] == 2){
					bfs(i, j);
					break;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < maxY; i++){
			for(int j = 0; j < maxX; j++){
				if(graph[i][j] == 1 && !visited[i][j]){
					graph2[i][j] = -1;
				}
				
				sb.append(graph2[i][j]).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private void bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { y, x });
		visited[y][x] = true;
		
		while(!queue.isEmpty()){
			int[] now = queue.poll();
			
			for(int i = 0; i < 4; i++){
				int nextY = now[0] + moveY[i];
				int nextX = now[1] + moveX[i];
				
				if(nextY >= 0 && nextX >= 0 && nextY < maxY && nextX < maxX){
					if(graph[nextY][nextX] != 0 && !visited[nextY][nextX]){
						graph2[nextY][nextX] = graph2[now[0]][now[1]] + 1;
						visited[nextY][nextX] = true;
						queue.add(new int[] { nextY, nextX });
					}
				}
			}
		}
	}
}