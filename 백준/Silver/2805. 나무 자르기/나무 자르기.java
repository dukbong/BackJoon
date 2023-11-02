import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] q = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // O(N)
		int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // O(N)
		
		int max = Arrays.stream(n).max().getAsInt(); // O(N)
		
		System.out.println(machine(n, max, 0, q[1]));
	}

	// O(N * logN)
	private long machine(int[] n, int max, int min, int question) {
		while(max > min){
			int mid = (max + min) / 2;
//			int len = Arrays.stream(n).map(i -> Math.max(0, i - mid)).sum(); // O(N)
			long len = 0;
			for(int i : n){
				long minusResult = i - mid;
				if(minusResult > 0){
					len += minusResult;
				}
			}
			
			// 이분 탐색
			if(len < question){
				max = mid;
			}else{
				min = mid + 1;
			}
		}
		return --min;
	}
}