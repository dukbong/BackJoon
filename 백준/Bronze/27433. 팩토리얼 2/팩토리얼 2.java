import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 그냥 풀기
//		long result = 1;
//		for(int i = 1; i <= n; i++){
//			result *= i;
//		}
//		System.out.println(result);
		
		// 재귀로 풀기
		long result2 = factory(n);
		System.out.println(result2);
	}

	private long factory(int n) {
		if(n == 0){
			return 1; // 0!
		}else{
			return n * factory(n - 1); // 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 
		}
	}
}