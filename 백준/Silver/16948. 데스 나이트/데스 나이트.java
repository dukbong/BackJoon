import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	int limit;
	// (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
	int[] moveY = { -2, -2, 0, 0, 2, 2 }, moveX = { -1, 1, -2, 2, -1, 1 };
	int[][] graph;
	boolean[][] visited;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		limit = Integer.parseInt(br.readLine());
		graph = new int[limit][limit];
		visited = new boolean[limit][limit];

		int[] location = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		bfs(location);
		
//		for(int[] ar : graph){
//			System.out.println(Arrays.toString(ar));
//		}
		
		int result = graph[location[2]][location[3]];
		if(result == 0){
			result = -1;
		}
		System.out.println(result);
	}

	private void bfs(int[] location) {

		int[] start = new int[] { location[0], location[1] };
		visited[start[0]][start[1]] = true;
		int[] end = new int[] { location[2], location[3] };
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()){
			int[] now = q.poll();
			
			if(now[0] == end[0] && now[1] == end[1]){
				return;
			}
			
			for(int i = 0; i < 6; i++){
				int nY = now[0] + moveY[i];
				int nX = now[1] + moveX[i];
				
				if(nY >= 0 && nX >= 0 && nY < limit && nX < limit){
					if(!visited[nY][nX]){
						graph[nY][nX] = graph[now[0]][now[1]] + 1;
						visited[nY][nX] = true;
						q.offer(new int[] { nY, nX });
					}
				}
			}
		}

	}

}
