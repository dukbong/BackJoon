import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	int ly, lx;
	char[][] graph;
	boolean[][][][] visited; // 빨강 파랑 나누자
	int[] my = {-1, 1, 0, 0}, mx = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
	
	class Test{
		int ry;
		int rx;
		int by;
		int bx;
		int count;
		public Test(int ry, int rx, int by, int bx, int count) {
			super();
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.count = count;
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ly = size[0]; lx = size[1];
		graph = new char[ly][lx];
		visited = new boolean[ly][lx][ly][lx];
		
		// 빨간공 위치
		int ryl = 0;
		int rxl = 0;
		
		// 파란공 위치
		int byl = 0;
		int bxl = 0;
		
		for(int i = 0; i < ly; i++){
			String str = br.readLine();
			// 빨간 공 위치
			if(str.indexOf("R") != -1){
				ryl = i;
				rxl = str.indexOf("R");
			}
			// 파란 공 위치
			if(str.indexOf("B") != -1){
				byl = i;
				bxl = str.indexOf("B");
			}
			
			graph[i] = str.toCharArray();
		}
		
		bfs(ryl, rxl, byl, bxl);
	}

	private void bfs(int ryl, int rxl, int byl, int bxl) {
		Queue<Test> q = new LinkedList<>();
		q.offer(new Test(ryl, rxl, byl, bxl, 1)); // 바로 들어간거 아니니깐
		visited[ryl][rxl][byl][bxl] = true;
		
		while(!q.isEmpty()){
			Test n = q.poll();
			
			// 10번 이하로 도착해야한다는 조건
			if(n.count > 10){
				System.out.println(-1);
				return;
			}
			
			for(int i = 0; i < 4; i++){
				// 파란
				int nextBy = n.by + my[i];
				int nextBx = n.bx + mx[i];
				boolean bh = true;
				// 벽에 닿을때까지 한방향으로 계속 움직인다.
				while(graph[nextBy][nextBx] != '#'){
					if(graph[nextBy][nextBx] == 'O'){
						// 파란 공이 골인 되면 안되기 때문에 checkPoint 추가
						bh = false;
						break;
					}
					nextBy += my[i];
					nextBx += mx[i];
				}
				// 빠지기 직전
				nextBy -= my[i];
				nextBx -= mx[i];
				
				if(!bh){
					continue;
				}
				
				// 빨강
				int nextRy = n.ry + my[i];
				int nextRx = n.rx + mx[i];
				
				while(graph[nextRy][nextRx] != '#'){
					if(graph[nextRy][nextRx] == 'O'){
						System.out.println(n.count);
						return;
					}
					nextRy += my[i];
					nextRx += mx[i];
				}
				nextRy -= my[i];
				nextRx -= mx[i];
				
				// 겹칠 수 없다.
				if(nextRx == nextBx && nextRy ==nextBy){
					if(i == 0){
						if(n.by < n.ry){
							nextRy++;
						}else{
							nextBy++;
						}
					}
					else if (i == 1){
						if(n.by < n.ry){
							nextBy--;
						}else{
							nextRy--;
						}
					}
					else if(i == 2){
						if(n.bx < n.rx){
							nextRx++;
						}else{
							nextBx++;
						}
					}
					else if(i == 3){
						if(n.bx < n.rx){
							nextBx--;
						}else{
							nextRx--;
						}
					}
				}
				if(!visited[nextRy][nextRx][nextBy][nextBx]){
					q.offer(new Test(nextRy, nextRx, nextBy, nextBx, n.count + 1));
					visited[nextRy][nextRx][nextBy][nextBx] = true;
				}
			}
			
		}
		System.out.println(-1);
	}
}