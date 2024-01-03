import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	int maxY, maxX;
	int[][] graph;
	int[][] dist;
	int[] moveY = {-1, 1, 0, 0}, moveX = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		maxY = size; maxX = size;
		
		graph = new int[maxY][maxX];
		dist = new int[maxY][maxX];
		
		for(int[] distRow : dist){
			Arrays.fill(distRow, Integer.MAX_VALUE);
		}
		
		dist[0][0] = 0;
		
		for(int i = 0; i < maxY; i++){
			int[] row = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			graph[i] = row;
		}
		bfs(0,0);
		
		System.out.println(dist[size - 1][size - 1]);
		
	}

	private void bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { y, x });
		
		while(!queue.isEmpty()){
			int[] now = queue.poll();
			
			for(int i = 0; i < 4; i++){
				int nextY = now[0] + moveY[i];
				int nextX = now[1] + moveX[i];
				
				if(nextY >= 0 && nextX >= 0 && nextY < maxY && nextX < maxX){
					if(dist[nextY][nextX] > dist[now[0]][now[1]]){
						if(graph[nextY][nextX] == 1){
							dist[nextY][nextX] = dist[now[0]][now[1]];
						}else{
							dist[nextY][nextX] = dist[now[0]][now[1]] + 1;
						}
						queue.offer(new int[] { nextY, nextX });
					}
				}
			}
		}
	}


}
