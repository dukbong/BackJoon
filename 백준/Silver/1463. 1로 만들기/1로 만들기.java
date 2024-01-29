import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	int[] dist;
	boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		dist = new int[num + 1];
		visited = new boolean[num + 1];
		search(num);
	}

	private void search(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		visited[num] = true;
		
		while(!q.isEmpty()){
			int now = q.poll();
			
			if(now == 1){
				System.out.println(dist[1]);
				return;
			}
			
			int next = now;
			for(int i = 0; i < 3; i ++){
				switch(i){
				case 0: if(now % 3 == 0) next = now / 3;
					break;
				case 1: if(now % 2 == 0) next = now / 2;
					break;
				case 2: next = now - 1;
					break;
				}
				
				if(next != now){
					if(!visited[next] && next >= 1){
						q.offer(next);
						visited[next] = true;
						dist[next] = dist[now] + 1;
					}
				}
			}
		}
	}

}