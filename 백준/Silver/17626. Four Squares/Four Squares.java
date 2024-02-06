import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        
        int[] dp = new int[x + 1];
        dp[1] = 1;
 
        for (int i = 2; i <= x; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; Math.pow(j, 2) <= i; j++) {
                int temp = i - (int)Math.pow(j, 2);
                min = Math.min(min, dp[temp]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[x]);
	}
}