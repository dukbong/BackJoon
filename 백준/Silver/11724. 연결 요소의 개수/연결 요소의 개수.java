import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[][] graph; // dfs
//	static ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>(); // bfs
	static boolean[] visited;
	static int V;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		V = size[0];
		graph = new int[size[0] + 1][size[0] + 1]; 
		visited = new boolean[size[0] + 1];

		int result = 0;

//		for(int i = 0; i < size[1]; i++){
//			graph2.add(new ArrayList<>());
//		}
		
		for (int i = 0; i < size[1]; i++) {
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			graph[arr[0]][arr[1]] = graph[arr[1]][arr[0]] = 1;
			
//			graph2.get(arr[0]).add(arr[1]);
//			graph2.get(arr[1]).add(arr[0]);
		}
		
		// 점점의 개수
		for (int i = 1; i <= V; i++) {
			if (!visited[i]) {
				dfs(i);
//				bfs(i);
				result++;
			}
		}

		System.out.println(result);
	}

//	private void bfs(int i) {
//		Queue<Integer> queue = new LinkedList<>();
//		queue.offer(i);
//		
//		while(!queue.isEmpty()){
//			int now = queue.poll();
//			int size = graph2.get(now).size();
//			
//			for(int j = 0; j < size; j++){
//				int newI = graph2.get(now).get(j);
//				
//				if(!visited[newI]){
//					queue.offer(newI);
//					visited[newI] = true;
//				}
//			}
//		}
//	}

	private void dfs(int i) {
		if (visited[i]) {
			return;
		}
		
		visited[i] = true;
		for (int j = 1; j <= V; j++) {
			if (graph[i][j] == 1) {
				dfs(j);
			}
		}

	}

}