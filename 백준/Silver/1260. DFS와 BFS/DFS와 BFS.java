import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		new Main().solution();
		
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] qPack = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int size 	  = qPack[0];
		int line 	  = qPack[1];
		int startNode = qPack[2];
		
		boolean[] bArr = new boolean[size + 1];
		int[][] nArr = new int[size + 1][size + 1];
		
		
		for(int i = 0; i < line; i++){
			int[] test = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			nArr[test[0]][test[1]] = nArr[test[1]][test[0]] = 1; // 인접 행렬 만들기.
		} 
		
//		for(int[] ar : nArr){
//			System.out.println(Arrays.toString(ar));
//		}
		
		dfs(startNode, bArr, nArr);
		sb.append("\n");
		Arrays.fill(bArr, false);
		bfs(startNode, bArr, nArr);
		System.out.println(sb);
	}

	private void dfs(int startNode, boolean[] bArr, int[][] nArr) {
		bArr[startNode] = true;
		sb.append(startNode).append(" ");
		
		for(int i = 0; i <= bArr.length - 1; i++){
			if(nArr[startNode][i] == 1 && !bArr[i]){
				dfs(i, bArr, nArr);
			}
		}
	}
	
	public static void bfs(int startNode, boolean[]bArr, int[][]nArr) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);
		bArr[startNode] = true;
		
		while(!queue.isEmpty()) {
			
			startNode = queue.poll();
			sb.append(startNode).append(" ");
			
			for(int i = 1 ; i <= bArr.length - 1; i++) {
				if(nArr[startNode][i] == 1 && !bArr[i]) {
					queue.add(i);
					bArr[i] = true;
				}
			}
		}	
	}
}