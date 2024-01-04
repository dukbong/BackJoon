import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	int maxY = 5, maxX = 5;
	int[][] graph = new int[maxY][maxX];
	int[] moveY = {-1,1,0,0}, moveX = {0,0,-1,1};
	
	int[] save = new int[6];
	Set<String> set = new HashSet<>();
	StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < maxY; i++){
			graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 0; i < maxY; i++){
			for(int j = 0; j < maxX; j++){
				dfs(i, j, 0);
			}
		}
		
		System.out.println(set.size());
	}

	private void dfs(int y, int x, int c) {
		if(c == 6){
			for(int i = 0; i < 6; i++){
				sb.append(save[i]);
			}
			set.add(sb.toString());
			sb.setLength(0); // 초기화
			return;
		}
		
		save[c] = graph[y][x];
		
		for(int i = 0; i < 4; i++){
			int nextY = y + moveY[i];
			int nextX = x + moveX[i];
			
			if(nextY >= 0 && nextX >= 0 && nextX < maxX && nextY < maxY){
				dfs(nextY, nextX, c + 1);
			}
			
		}
	}


}
