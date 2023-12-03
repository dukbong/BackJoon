import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] on = new int[101];
	static int[] resultArr = new int[101];
	static boolean[] bArr = new boolean[101];
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arrSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i = 0; i < arrSize[0] + arrSize[1]; i++) {
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			on[arr[0]] = arr[1];
		}
		
		bfs(1);
	}

	private void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		bArr[x] = true;
		resultArr[x] = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			// 최종 목적지
			if(now == 100) {
				System.out.println(resultArr[100]);
				return;
			}
			
			for(int i = 1; i <= 6; i++) {
				int next =  now + i;
				
				if(100 >= next && !bArr[next]) {
					bArr[next] = true;
					if(on[next] != 0) {
						if(!bArr[on[next]]) {
							queue.add(on[next]);
							bArr[on[next]] = true;
							resultArr[on[next]] = resultArr[now] + 1;
						}
					}else {
						queue.add(next);
						resultArr[next] = resultArr[now] + 1;
					}
				}
				
			}
		}
	}

}
