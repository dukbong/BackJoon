import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int maxY, maxX;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();
	static int[] moveY = {-1,1,0,0}, moveX = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] sizeAndSquareCount = Arrays.stream(br.readLine().split(" "))
			                             .mapToInt(Integer::parseInt)
			                             .toArray();
		
		maxY = sizeAndSquareCount[1];
		maxX = sizeAndSquareCount[0];
		
		visited = new boolean[maxY][maxX];
		
		int squareCount = sizeAndSquareCount[2];
		
		// 벽 만들기
		for(int i = 0; i < squareCount; i++){
			int[] squareInfo = Arrays.stream(br.readLine().split(" "))
					                 .mapToInt(Integer::parseInt)
					                 .toArray();
			
			int squareMaxY = Math.max(squareInfo[0], squareInfo[2]);
			int squareMinY = Math.min(squareInfo[0], squareInfo[2]);
			int squareMaxX = Math.max(squareInfo[1], squareInfo[3]);
			int squareMinX = Math.min(squareInfo[1], squareInfo[3]);
			
			for(int j = squareMinY; j < squareMaxY; j++){
				for(int k = squareMinX; k < squareMaxX; k++){
					visited[j][k] = true;
				}
			}
		}
		
		for(int i = 0; i < maxY; i++){
			for(int j = 0; j < maxX; j++){
				if(!visited[i][j]){
					search(i,j);
				}
			}
		}
		
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(int i : list){
			sb.append(i).append(" ");
		}
		
		System.out.print(sb);
	}

	private void search(int y, int x) {
		
		// search를 시작했다면 무조건 우선 넓이는 1부터 시작이다.
		int count = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { y , x });
		visited[y][x] = true;
		
		while(!queue.isEmpty()){
			int[] now = queue.poll();
			
			for(int i = 0; i < 4; i++){
				int nextY = now[0] + moveY[i];
				int nextX = now[1] + moveX[i];
				
				if(nextY >= 0 && nextY < maxY && nextX >= 0 && nextX < maxX){
					if(!visited[nextY][nextX]){
						count++; // 넓이
						visited[nextY][nextX] = true;
						queue.offer(new int[] {nextY, nextX});
					}
				}
			}
		}
		list.add(count);
	}

}

/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2

3
1 7 13

*/
