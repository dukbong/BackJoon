import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Main {
	
	int ly, lx;
	char[][] graph;
	boolean[][] visited;
	int[] mY = {-1,1,0,0}, mX = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < testCase; i++){
			int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			ly = size[0]; lx = size[1];
			graph = new char[ly][lx];
			visited = new boolean[ly][lx];
			for(int j = 0; j < ly; j++){
				graph[j] = br.readLine().toCharArray();
			}
			sb.append(IntStream.range(0, ly).flatMap(k -> IntStream.range(0, lx).filter(l -> graph[k][l] == '#' && !visited[k][l]).peek(z -> bfs(new int[] {k, z}))).count()).append("\n");
		}
		System.out.println(sb);
	}

	private void bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		visited[start[0]][start[1]] = true;
		q.offer(start);
		
		while(!q.isEmpty()){
			int[] now = q.poll();
			
			for(int i = 0; i < 4; i++){
				int ny = now[0] + mY[i];
				int nx = now[1] + mX[i];
				
				if(ny >= 0 && nx >= 0 && ny < ly && nx < lx){
					if(graph[ny][nx] == '#' && !visited[ny][nx]){
						q.offer(new int[] {ny,nx});
						visited[ny][nx] = true;
					}
				}
			}
		}
		
	}

}
