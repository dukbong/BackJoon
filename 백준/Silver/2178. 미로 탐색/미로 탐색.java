import java.util.*;
import java.io.*;

public class Main {

	static int[][] arr;
	static boolean[][] bArr;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ySize;
	static int xSize;
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] endPoint = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ySize = endPoint[0];
		xSize = endPoint[1];
		arr = new int[ySize][xSize];
		bArr = new boolean[ySize][xSize];
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		bArr[0][0] = true;
		bfs(0,0);
		System.out.println(arr[ySize - 1][xSize - 1]);
	}

	private void bfs(int y, int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{y,x});
		
		while(!queue.isEmpty()){
			int[] now = queue.poll();
			int nowY = now[0];
			int nowX = now[1];
			
			for(int i = 0; i < 4; i++){
				int nextY = nowY + dy[i];
				int nextX = nowX + dx[i];
				
				if(nextY >= 0 && nextX >= 0 && nextY < ySize && nextX < xSize && !bArr[nextY][nextX] && arr[nextY][nextX] != 0){
					queue.add(new int[]{nextY, nextX});
					arr[nextY][nextX] = arr[nowY][nowX] + 1;
					bArr[nextY][nextX] = true;
				}
			}
		}
	}
}