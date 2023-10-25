import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private int[] readLineToArr(String str) {
		return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	private void solution() throws IOException {
		// 뇌가 녹아버릴꺼같다...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] Q = readLineToArr(br.readLine());
		int[] arr = readLineToArr(br.readLine()); // 기준이 된다.
		int test = 0;
		
		int[] count = new int[Q[1]];
		for(int i = 0; i < Q[0]; i++){
			test = (test + arr[i]) % Q[1];
			count[test]++;
		}
		
		long ans = count[0];
		for(int i = 0; i < Q[1]; i++){
			ans += (long) count[i] * (count[i] - 1) / 2;
		}
		System.out.println(ans);
	}
}