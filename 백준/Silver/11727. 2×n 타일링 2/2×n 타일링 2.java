import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		BigInteger[] dp = new BigInteger[1001];
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(3);
		// dp[n] = dp[n - 1] +  2 * dp[n - 2]
		
		for(int i = 3; i <= num; i++){
			dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
		}
		System.out.println(dp[num].mod(BigInteger.valueOf(10007)));
		
	}

}