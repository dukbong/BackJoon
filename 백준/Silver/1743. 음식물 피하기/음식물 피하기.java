import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	int maxY, maxX, trashCount;
	int[][] graph;
	boolean[][] visited;
	int[] mY = {-1,1,0,0}, mX = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		maxY = question[0]; maxX = question[1]; trashCount = question[2];
		
		graph = new int[maxY][maxX];
		visited = new boolean[maxY][maxX];
		
		for(int i = 0; i < trashCount; i++){
			int[] trashLocation = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			graph[trashLocation[0] - 1][trashLocation[1] - 1] = 1;
		}
		
		int trashSize = 0;
		int sizeCheck = 0;
		for(int i = 0; i < maxY; i++){
			for(int j = 0; j < maxX; j++){
				if(graph[i][j] == 1 && !visited[i][j]){
					sizeCheck = bfs(new int[] { i, j });
					if(trashSize < sizeCheck){
						trashSize = sizeCheck;
					}
				}
			}
		}
		
		System.out.println(trashSize);
		
	}

	private int bfs(int[] start) {
		int trashSize = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()){
			int[] now = q.poll();
			
			for(int i = 0; i < 4; i++){
				int nY = now[0] + mY[i];
				int nX = now[1] + mX[i];
				
				if(nY >= 0 && nX >= 0 && nY < maxY && nX < maxX){
					if(graph[nY][nX] == 1 && !visited[nY][nX]){
						q.offer(new int[] { nY, nX });
						visited[nY][nX] = true;
						trashSize++;
					}
				}
			}
			
		}
		
		return trashSize;
	}

}