	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
	
	public class Main {
	
		static boolean[][][] visited;
		static int[][] square;
		static int[] dy = { -1, 1, 0, 0 };
		static int[] dx = { 0, 0, -1, 1 };
		static int n;
		static int m;
		
	    static class Point {
	        int x;
	        int y;
	        boolean destroyed;
	        int cnt;

	        public Point(int x, int y, boolean destroyed, int cnt) {
	            this.x = x;
	            this.y = y;
	            this.destroyed = destroyed;
	            this.cnt = cnt;
	        }
	    }
	
		public static void main(String[] args) throws IOException {
			new Main().solution();
		}
	
		private void solution() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			int[] squareSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			n = squareSize[0];
			m = squareSize[1];
//			ArrayList<int[]> list = new ArrayList<>();
//			list.add(new int[] { 0, 0 });
			square = new int[n][m];
			visited = new boolean[n][m][2];
					
//			int min = Integer.MAX_VALUE;
	
			for (int i = 0; i < n; i++) {
				square[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
/*				for (int j = 0; j < maxX; j++) {
					if (square[i][j] == 1) {
						list.add(new int[] { i, j });
					}
				}*/
			}
	
/*			for (int i = 0; i < list.size(); i++) {
				int[] brokenWall = list.get(i);
				square[brokenWall[0]][brokenWall[1]] = 0;
				int x = bfs(0, 0, 0);
	
				if (x > 0 && min > x) {
					min = x;
				}
				if(i > 0){
					square[brokenWall[0]][brokenWall[1]] = 1;
				}
			}
	
			if (min == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(min);
			}*/
			
			System.out.println(bfs());
		}
	
/*		private int bfs() {
	
			int[][] tempArr = new int[maxY][maxX];
			for (int i = 0; i < maxY; i++) {
				for (int j = 0; j < maxX; j++) {
					tempArr[i][j] = square[i][j];
				}
			}
	
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { y, x });
	
			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				
				for (int i = 0; i < 4; i++) {
					int nextY = now[0] + dy[i];
					int nextX = now[1] + dx[i];
	
					if (nextY >= 0 && nextX >= 0 && nextY < maxY && nextX < maxX) {
						if (tempArr[nextY][nextX] == 0) {
							queue.add(new int[] { nextY, nextX });
							tempArr[nextY][nextX] = tempArr[now[0]][now[1]] + 1;
						}
					}
	
				}
			}
			
			return tempArr[maxY - 1][maxX - 1];
		}*/
		
		public static int bfs() {
	        Queue<Point> queue = new LinkedList<>();

	        // 시작점을 큐에 넣습니다.
	        queue.offer(new Point(0, 0, false, 1));
	        visited[0][0][0] = true;

	        while (!queue.isEmpty()) {
	            Point point = queue.poll();

	            // 도착하면 지나간 타일 수를 반환합니다.
	            if (point.x == n - 1 && point.y == m - 1) {
	                return point.cnt;
	            }

	            for (int d = 0; d < 4; d++) {
	                int newX = point.x + dx[d];
	                int newY = point.y + dy[d];

	                // 배열을 벗어난 경우는 넘어갑니다.
	                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
	                    continue;
	                }

	                // 벽을 부순적이 있는지 확인합니다.
	                if (point.destroyed) {
	                    // 벽을 부순적이 있을 때 해당 지점이 벽이 아니고, 방문한적이 없다면 큐에 정보를 넣습니다.
	                    if (square[newX][newY] == 0 && !visited[newX][newY][1]) {
	                        visited[newX][newY][1] = true;
	                        queue.offer(new Point(newX, newY, true, point.cnt + 1));
	                    }
	                } else {
	                    // 해당 위치가 벽인지 확인합니다.
	                    if (square[newX][newY] == 1) {
	                        // 벽이라면 벽을 부수고 큐에 값을 넣습니다.
	                        visited[newX][newY][1] = true;
	                        queue.offer(new Point(newX, newY, true, point.cnt + 1));
	                    } else if (!visited[newX][newY][0]){
	                        // 벽이 아니고 방문한적이 없다면 큐에 값을 넣습니다.
	                        visited[newX][newY][0] = true;
	                        queue.offer(new Point(newX, newY, false, point.cnt + 1));
	                    }
	                }
	            }
	        }

	        return -1;
	    }
	
	}
