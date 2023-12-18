import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int result = 0;
	static int[][] graph;
	static int[] moveY = new int[]{-1,1,0,0};
	static int[] moveX = new int[]{0,0,-1,1};
	static int maxY, maxX;
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
	
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		maxY = size[0];
		maxX = size[1];
		
		// graph size fixed
		graph = new int[maxY][maxX];
		
		
		// graph value fixed
		for(int i = 0; i < maxY; i++){
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		// creating block ( 모든 경우 )
		dfs(0);
		
		System.out.println(result);
	}

	private void dfs(int count) {
		if(count == 3){
			bfs();
			return;
		}
		
		for(int i = 0; i < maxY; i++){
			for(int j = 0; j < maxX; j++){
				if(graph[i][j] == 0){
					graph[i][j] = 1;
					dfs(count + 1);
					graph[i][j] = 0;
				}
			}
		}
	}

	private void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		
		int[][] tempGraph = new int[maxY][maxX];
		
		boolean[][] visited = new boolean[maxY][maxX];
		
		// copy to origin graph
		for(int i = 0; i < maxY; i++){
			tempGraph[i] = graph[i].clone();
		}
		
		for(int i = 0; i < maxY; i++){
			for(int j = 0; j < maxX; j++){
				if(tempGraph[i][j] == 2){
					queue.offer(new int[]{i, j});
					visited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()){
			int[] now = queue.poll();
			
			for(int i = 0; i < 4; i++){
				int nextY = now[0] + moveY[i];
				int nextX = now[1] + moveX[i];
				
				if(nextY >= 0 && nextX >= 0 && nextY < maxY && nextX < maxX){
					if(!visited[nextY][nextX] && tempGraph[nextY][nextX] == 0){
						queue.offer(new int[]{nextY, nextX});
						tempGraph[nextY][nextX] = 2;
					}
				}
			}
		}
		binArea(tempGraph);
	}

	private void binArea(int[][] tempGraph) {
		int binCount = 0;
		for(int i = 0; i < maxY; i++){
			// stream으로 바꿔보기
			binCount += Arrays.stream(tempGraph[i]).filter(j -> j == 0).count();
//			for(int j = 0; j < maxX; j++){
//				if(tempGraph[i][j] == 0){
//					binCount++;
//				}
//			}
		}
		result = Integer.max(result, binCount);
	}
}