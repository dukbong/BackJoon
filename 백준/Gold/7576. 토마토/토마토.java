import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[][] square;
	static int maxY;
	static int maxX;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] squareSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		maxY = squareSize[1];
		maxX = squareSize[0];
		
		square = new int[maxY][maxX];
		
		for(int i = 0; i < maxY; i++) {
			square[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 0; i < maxY; i++) {
			for(int j = 0; j < maxX; j++) {
				if(square[i][j] == 1) {
					queue.add(new int[] {i,j});
				}
			}
		}
		// 최대값을 가져오면 된다.
		System.out.println(bfs());
		
	}

	private int bfs() {
		
		int max = 1;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextY = now[0] + dy[i];
				int nextX = now[1] + dx[i];
				
				if(nextY >= 0 && nextX >= 0 && nextY < maxY && nextX < maxX && square[nextY][nextX] == 0) {
					queue.add(new int[] {nextY, nextX});
					max = square[now[0]][now[1]] + 1;
					square[nextY][nextX] = max;
				}
			}
		}
		
		
		for(int i = 0; i < maxY; i++) {
			for(int j = 0; j < maxX; j++) {
				if(square[i][j] == 0) {
					return -1;
				}
			}
		}
		return max - 1;
		
	}
}
