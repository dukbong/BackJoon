import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Main {

	static int[][] arr;
	static int size;
	static boolean[][] vistied;
	static int count = 1;
	
	// 이동 요소
	static int[] dx = new int[]{0, 0, -1, 1};
	static int[] dy = new int[]{-1, 1, 0, 0};
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		arr = new int[size][size];
		vistied = new boolean[size][size];
		
		// 몇개가 나올지 몰라서 List로 만들어줬다.
		ArrayList<Integer> list = new ArrayList<>();
		
		int danjisu = 0;
		
		for(int i = 0; i < size; i++){
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(arr[i][j] == 1 && !vistied[i][j]){
					vistied[i][j] = true;
					dfs(i,j);
					list.add(count);
					danjisu++;
					count = 1;
				}
			}
		}
		
		sb.append(danjisu).append("\n");
		Collections.sort(list); // 오름 차순
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			sb.append(it.next()).append("\n");
		}
		
		System.out.println(sb);
	}

	private void dfs(int y, int x) {
		for(int i = 0; i < 4; i++){
			int nowY = y + dy[i];
			int nowX = x + dx[i];
			if(nowY >= 0 && nowX >= 0 && nowY < size && nowX < size && arr[nowY][nowX] == 1 && !vistied[nowY][nowX]){
				vistied[nowY][nowX] = true;
				dfs(nowY, nowX);
				count++;
			}
		}
	}
}