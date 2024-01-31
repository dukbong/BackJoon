import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		BigInteger[] dp = new BigInteger[1001]; // 최대 크기
		dp[1] = BigInteger.valueOf(1); // 2 * 1 타일에는 1가지의 조합으로 들어간다.
		dp[2] = BigInteger.valueOf(2); // 2 * 2 타일에는 2가지의 조합으로 들어간다.
		for(int i = 3; i <= size; i++){
			// ex) 2 * 3 타일의 경우 3가지의 조합이 가능하다.
			// 이로 인해 n의 타일 조합은 n - 1 + n - 2라는 식을 생각할 수 있게 된다.
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}
		System.out.println(dp[size].mod(BigInteger.valueOf(10007)));
	}
}