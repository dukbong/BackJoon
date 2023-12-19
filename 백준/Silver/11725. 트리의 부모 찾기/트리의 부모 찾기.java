import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	// 간선의 관계를 나타낼 ArrayList
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	static int[] resultArr;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 점의 개수
		int point = Integer.parseInt(br.readLine());

		visited = new boolean[point + 1];
		resultArr = new int[point + 1];
		
		for(int i = 0; i <= point; i++){
			list.add(new ArrayList<>());
		}
		
		// 간선을 행렬로 그려준다.
		for (int i = 0; i < point - 1; i++) {
			int[] node = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			list.get(node[0]).add(node[1]);
			list.get(node[1]).add(node[0]);
		}
		
		parentNode(1);
		StringBuilder sb = new StringBuilder();
		
		for(int i = 2; i <= point; i++){
			sb.append(resultArr[i]).append("\n");
		}
		System.out.println(sb);
	}

	private void parentNode(int children) {
		
		Queue<Integer> queue = new LinkedList<>();
		visited[children] = true;
		queue.offer(children);
		
		while(!queue.isEmpty()){
			
			int now = queue.poll();
			
			int size = list.get(now).size();
			
			for(int i = 0; i < size; i++){
				int parent = list.get(now).get(i);
				
				if(!visited[parent]){
					visited[parent] = true;
					resultArr[parent] = now;
					queue.add(parent);
				}
			}
		}
	}

}

/*

7
1 6
6 3
3 5
4 1
2 4
4 7


4
6
1
3
1
4

*/