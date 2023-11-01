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
		int[] q = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		long[] k = new long[q[0]];
		long max = 0;

		for (int i = 0; i < q[0]; i++) {
			long num = Integer.parseInt(br.readLine());
			k[i] = num;
			if (max < num) {
				max = num;
			}
		}
		System.out.println(machine(k, max + 1, max / 2, 0, q[1]));
	}

	private long machine(long[] k, long max, long mid, long min, long limit) {
//		2차 재귀 시도 : 처참하게 시간초과
//		int count = 0;
//		mid = (max + min) / 2;
//
//		for (int i = 0; i < k.length; i++) {
//			count += k[i] / mid;
//		}
//
//		if (count == limit) {
//			System.out.println(mid);
//			return;
//		} else if (count > limit) {
//			machine(k, max, mid, min + 1, limit);
//		} else {
//			machine(k, mid, mid, min, limit);
//		}
		
		while(min < max){
			
			int count = 0;
			mid = (max + min) / 2;
	
			for (int i = 0; i < k.length; i++) {
				count += (k[i] / mid);
			}
			
			if(count >= limit){
				min = mid + 1;
			}else{
				max = mid;
			}
			
		}
		return --max;
	}
	
//  1차 시도 : 사실 그냥 가장 먼저 생각 나는 방법으로 풀었지만 역시나 시간초과 ... 이건 그냥 노가다 성이다.
//	private int machine(int[] k, int limit, int max, int start) {
//		for (int i = 0; i < k.length; i++) {
//			start += k[i] / max;
//		}
//
//		if (start == limit) {
//			return max;
//		} else {
//			return test(k, limit, max - 1, 0);
//		}
//	}
}