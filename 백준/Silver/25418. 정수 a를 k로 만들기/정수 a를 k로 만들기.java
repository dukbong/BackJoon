import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	int start, end;
	boolean visited[];
	
	public static void main(String[] args) throws IOException {
		new Main().sol();
	}

	private void sol() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		start = question[0];
		end = question[1];
		visited = new boolean[end + 1];
		visited[start] = true;
		
		bfs();
	}

	private void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start, 0});
		
		while(!q.isEmpty()){
			int[] now = q.poll();
			
			if(now[0] == end){
				System.out.println(now[1]);
				return;
			}
			
			if(now[0] * 2 <= end){
				visited[now[0] * 2] = true;
				q.offer(new int[] {now[0] * 2, now[1] + 1});
			}
			
			if(!visited[now[0] + 1]){
				q.offer(new int[] {now[0] + 1, now[1] + 1});
			}
			
		}
	}

}
