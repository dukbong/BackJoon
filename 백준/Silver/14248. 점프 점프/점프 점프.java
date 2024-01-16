import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	int[] graph;
	boolean[] check;
	int size, count = 1;
	int[] way = new int[] { -1, 1 };
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		size = Integer.parseInt(br.readLine());
		check = new boolean[size];
		graph = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int start = Integer.parseInt(br.readLine());
		
		bfs(start - 1);
		
		System.out.println(count);
	}

	private void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		check[start] = true;
		
		while(!q.isEmpty()){
			int now = q.poll();
			
			int num = graph[now];
			
			for(int i = 0; i < 2; i++){
				int nextWay = way[i] * num + now;
				if(nextWay >= 0 && nextWay < size && !check[nextWay]){
					check[nextWay] = true;
					q.offer(nextWay);
					count++;
				}
			}
		}
	}


}
